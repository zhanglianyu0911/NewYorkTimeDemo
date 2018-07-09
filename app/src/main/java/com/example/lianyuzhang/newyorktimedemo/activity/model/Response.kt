package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("docs")
	val docs: List<DocsItem?>? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null
)