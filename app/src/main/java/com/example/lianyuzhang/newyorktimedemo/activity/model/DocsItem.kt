package com.example.lianyuzhang.newyorktimedemo.activity.model

import com.google.gson.annotations.SerializedName

data class DocsItem(

	@field:SerializedName("snippet")
	val snippet: String? = null,

	@field:SerializedName("print_page")
	val printPage: String? = null,

	@field:SerializedName("keywords")
	val keywords: List<KeywordsItem?>? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("blog")
	val blog: Blog? = null,

	@field:SerializedName("uri")
	val uri: String? = null,

	@field:SerializedName("news_desk")
	val newsDesk: String? = null,

	@field:SerializedName("pub_date")
	val pubDate: String? = null,

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("multimedia")
	val multimedia: List<MultimediaItem?>? = null,

	@field:SerializedName("word_count")
	val wordCount: Int? = null,

	@field:SerializedName("type_of_material")
	val typeOfMaterial: String? = null,

	@field:SerializedName("web_url")
	val webUrl: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("headline")
	val headline: Headline? = null,

	@field:SerializedName("byline")
	val byline: Byline? = null,

	@field:SerializedName("document_type")
	val documentType: String? = null,

	@field:SerializedName("section_name")
	val sectionName: String? = null
)