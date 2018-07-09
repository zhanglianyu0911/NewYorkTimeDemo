package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class Byline(

	@field:SerializedName("original")
	val original: String? = null,

	@field:SerializedName("person")
	val person: List<PersonItem?>? = null,

	@field:SerializedName("organization")
	val organization: Any? = null
)