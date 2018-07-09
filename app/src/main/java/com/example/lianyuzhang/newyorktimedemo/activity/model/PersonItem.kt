package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class PersonItem(

	@field:SerializedName("firstname")
	val firstname: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("qualifier")
	val qualifier: Any? = null,

	@field:SerializedName("organization")
	val organization: String? = null,

	@field:SerializedName("middlename")
	val middlename: Any? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("title")
	val title: Any? = null,

	@field:SerializedName("lastname")
	val lastname: String? = null
)