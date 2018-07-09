package com.example.lianyuzhang.newyorktimedemo.activity.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.lianyuzhang.newyorktimedemo.R
import com.example.lianyuzhang.newyorktimedemo.activity.NewsDetailsActivity
import com.example.lianyuzhang.newyorktimedemo.activity.api.RetrofitService
import com.example.lianyuzhang.newyorktimedemo.activity.model.DocsItem
import com.squareup.picasso.Picasso

class NewsListAdapter constructor(
        private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items = mutableListOf<DocsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater.inflate(R.layout.new_list_item, parent, false))
    }

    override fun getItemCount() = items.size;

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var newsHolder = holder as NewsViewHolder
        var newsUrl: String? = null
        newsHolder.headlineText.text = items[position].headline!!.main
        if (items[position].multimedia!!.isNotEmpty()) {
            var imageUrl = RetrofitService.API_IMAGE_BASE_URL + items[position].multimedia!![0]!!.url
            Picasso.with(context).load(imageUrl).into(newsHolder.newsImage)
            newsUrl = items[position].webUrl
        }
        newsHolder.itemView.setOnClickListener({
            var intent = Intent(context, NewsDetailsActivity::class.java)
            if (newsUrl == null) {
                Toast.makeText(context, "Error on loading news", Toast.LENGTH_LONG).show()
            } else {
                intent.putExtra(WEB_URL, newsUrl)
                context.startActivity(intent)
            }
        })
    }

    fun setItems(items: List<DocsItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    internal class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headlineText = itemView.findViewById(R.id.headline) as TextView
        val newsImage = itemView.findViewById(R.id.newsImage) as ImageView
    }

    companion object {
        const val WEB_URL = "webUrl"
    }
}