package com.example.lianyuzhang.newyorktimedemo.activity.presenter

import com.example.lianyuzhang.newyorktimedemo.activity.api.RetrofitService
import com.example.lianyuzhang.newyorktimedemo.activity.model.DocsItem
import com.example.lianyuzhang.newyorktimedemo.activity.model.NewsResponse
import com.example.lianyuzhang.newyorktimedemo.activity.presentation.NewsListPresentation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
* A presenter is to wrap all business logic
*/
class NewsListPresenter constructor(val presentation: NewsListPresentation) {
    //region presenter lifecycle callback
    fun onCreate() {
        //no-op
    }

    fun onStart() {
        // By default show the first page with null parameter
        query(null, null, null, null, null, 0)
    }

    fun onResume() {
        //no-op
    }

    fun onPause() {
        //no-op
    }

    fun onStop() {
        //no-op
    }

    fun onDestroy() {
        //no-op
    }
    //endregion presenter lifecycle callback

    fun query(
            q: String?,
            fq: String?,
            beginDate: String?,
            endDate: String?,
            sort: String?,
            page: Int
    ) {
        val call = RetrofitService.getInstance().query(q, fq, beginDate, endDate, sort, page)
        presentation.showLoadingBar(true)
        call.enqueue(object: Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                presentation.showLoadingBar(false)
                presentation.showErrorMessage()
            }

            override fun onResponse(call: Call<NewsResponse>?, response: Response<NewsResponse>?) {
                presentation.showLoadingBar(false)
                if (response != null) {
                    if (response.body() == null) {
                        presentation.showErrorMessage()
                        return
                    }
                }
                var article = response!!.body()!!.response!!.docs as ArrayList<DocsItem>
                presentation.setItems(article)
            }
        })
    }
}