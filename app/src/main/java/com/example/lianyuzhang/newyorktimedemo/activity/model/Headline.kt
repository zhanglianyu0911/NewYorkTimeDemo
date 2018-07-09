package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class Headline(

	@field:SerializedName("sub")
	val sub: Any? = null,

	@field:SerializedName("content_kicker")
	val contentKicker: String? = null,

	@field:SerializedName("name")
	val name: Any? = null,

	@field:SerializedName("main")
	val main: String? = null,

	@field:SerializedName("seo")
	val seo: Any? = null,

	@field:SerializedName("print_headline")
	val printHeadline: String? = null,

	@field:SerializedName("kicker")
	val kicker: String? = null
)