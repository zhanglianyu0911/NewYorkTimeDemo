package com.example.lianyuzhang.newyorktimedemo.activity.presentation

import com.example.lianyuzhang.newyorktimedemo.activity.model.DocsItem

/*
* Presentation is for view interface to setup the view
*/
interface NewsListPresentation {
    fun setItems(items: List<DocsItem>)

    fun showErrorMessage()

    fun showLoadingBar(show: Boolean)
}