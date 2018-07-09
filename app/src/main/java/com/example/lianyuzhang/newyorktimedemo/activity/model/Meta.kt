package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class Meta(

	@field:SerializedName("hits")
	val hits: Int? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("time")
	val time: Int? = null
)