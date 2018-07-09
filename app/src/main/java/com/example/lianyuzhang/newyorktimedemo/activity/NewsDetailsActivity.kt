package com.example.lianyuzhang.newyorktimedemo.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.ShareActionProvider
import android.view.Menu
import com.example.lianyuzhang.newyorktimedemo.R
import com.example.lianyuzhang.newyorktimedemo.activity.adapter.NewsListAdapter
import com.example.lianyuzhang.newyorktimedemo.activity.presentation.NewsDetailsPresentation
import com.example.lianyuzhang.newyorktimedemo.activity.presenter.NewsDetailsPresenter
import kotlinx.android.synthetic.main.activity_news_details.*
import android.webkit.WebViewClient

/*
* Show News detail
*/
class NewsDetailsActivity : AppCompatActivity(), NewsDetailsPresentation {
    private lateinit var presenter: NewsDetailsPresenter
    private lateinit var newsUrl: String

    //region lifecycle callback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        presenter = NewsDetailsPresenter(this)
        presenter.onCreate()

    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
        var intent = intent
        newsUrl = intent.getStringExtra(NewsListAdapter.WEB_URL)
        newsWebView.webViewClient = WebViewClient()
        newsWebView.settings.javaScriptEnabled = true
        newsWebView.loadUrl(newsUrl)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
    //endregion lifecycle callback

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.news_detail_menu, menu)
        var menuItem = menu!!.findItem(R.id.shareButton)
        var shareButton = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        shareButton.setShareIntent(Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(android.content.Intent.EXTRA_TEXT, newsUrl))
        return super.onCreateOptionsMenu(menu)
    }
}
