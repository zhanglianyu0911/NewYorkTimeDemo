package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(

	@field:SerializedName("copyright")
	val copyright: String? = null,

	@field:SerializedName("response")
	val response: Response? = null,

	@field:SerializedName("status")
	val status: String? = null
)