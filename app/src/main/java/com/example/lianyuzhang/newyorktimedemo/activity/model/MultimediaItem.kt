package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class MultimediaItem(

	@field:SerializedName("legacy")
	val legacy: Legacy? = null,

	@field:SerializedName("subtype")
	val subtype: String? = null,

	@field:SerializedName("crop_name")
	val cropName: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("caption")
	val caption: Any? = null,

	@field:SerializedName("subType")
	val subType: String? = null,

	@field:SerializedName("credit")
	val credit: Any? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)