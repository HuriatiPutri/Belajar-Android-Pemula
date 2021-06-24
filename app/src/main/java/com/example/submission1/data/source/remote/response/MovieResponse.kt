package com.example.submission1.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MovieResponse(
	val page: Int? = null,
	val totalPages: Int? = null,
	val results: List<ResultsItem?>? = null,
	val totalResults: Int? = null
)

@Parcelize
data class ResultsItem(
	@field:SerializedName("original_title")
	val originalTitle: String? = null,
	val title: String? = null,
	@field:SerializedName("poster_path")
	val posterPath: String? = null,
	val id: Int? = null,
): Parcelable

