package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class Legacy(

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("thumbnailwidth")
	val thumbnailwidth: Int? = null,

	@field:SerializedName("thumbnailheight")
	val thumbnailheight: Int? = null,

	@field:SerializedName("widewidth")
	val widewidth: Int? = null,

	@field:SerializedName("wideheight")
	val wideheight: Int? = null,

	@field:SerializedName("wide")
	val wide: String? = null,

	@field:SerializedName("xlarge")
	val xlarge: String? = null,

	@field:SerializedName("xlargewidth")
	val xlargewidth: Int? = null,

	@field:SerializedName("xlargeheight")
	val xlargeheight: Int? = null
)