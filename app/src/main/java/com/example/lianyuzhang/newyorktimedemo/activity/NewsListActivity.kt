package com.example.lianyuzhang.newyorktimedemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.example.lianyuzhang.newyorktimedemo.R
import com.example.lianyuzhang.newyorktimedemo.activity.adapter.NewsListAdapter
import com.example.lianyuzhang.newyorktimedemo.activity.item_decoration.SimpleDividerItemDecoration
import com.example.lianyuzhang.newyorktimedemo.activity.model.DocsItem
import com.example.lianyuzhang.newyorktimedemo.activity.presentation.NewsListPresentation
import com.example.lianyuzhang.newyorktimedemo.activity.presenter.NewsListPresenter
import kotlinx.android.synthetic.main.activity_news_list.*

/*
* Show News List
*/
class NewsListActivity : AppCompatActivity(), NewsListPresentation, SearchView.OnQueryTextListener {

    private lateinit var presenter: NewsListPresenter
    private var adapter = NewsListAdapter(this)
    private var query: String? = null
    private var page: Int = 0

    //region lifecycle callback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        presenter = NewsListPresenter(this)
        presenter.onCreate()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(SimpleDividerItemDecoration(this))
        previousPage.setOnClickListener({
            if (page == 0) {
                Toast.makeText(this, "Already first page", Toast.LENGTH_LONG).show()
            } else {
                presenter.query(query, null, null, null, null, page--)
            }
        })

        nextPage.setOnClickListener({
            presenter.query(query, null, null, null, null, page++)
        })
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onStop() {
        recyclerView.adapter = null
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
    //endregion lifecycle callback

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_view_menu, menu)
        var menuItem = menu!!.findItem(R.id.searchBar)
        var searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        presenter.query(query, null, null, null, null, 0)
        this.query = query
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    //region presentation callback
    override fun setItems(items: List<DocsItem>) {
        adapter.setItems(items)
    }

    override fun showErrorMessage() {
        Toast.makeText(
                this,
                resources.getString(R.string.network_error_message)
                , Toast.LENGTH_LONG
        ).show()
    }

    override fun showLoadingBar(show: Boolean) {
        if (show) {
            loadingBar.visibility = View.VISIBLE
        } else {
            loadingBar.visibility = View.GONE
        }
    }
    //endregion presentation callback
}
