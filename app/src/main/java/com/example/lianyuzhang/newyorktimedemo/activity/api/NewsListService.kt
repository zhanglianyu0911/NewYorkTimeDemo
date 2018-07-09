package com.example.lianyuzhang.newyorktimedemo.activity.api

import com.example.lianyuzhang.newyorktimedemo.activity.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsListService {
    @GET("articlesearch.json")
    fun query(
            @Query("q") query: String?,
            @Query("fq") filteredQuery: String?,
            @Query("begin_date") beginDate: String?,
            @Query("end_date") endDate: String?,
            @Query("sort") sort: String?,
            @Query("page") page: Int?): Call<NewsResponse>
}