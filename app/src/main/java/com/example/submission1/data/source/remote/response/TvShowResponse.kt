package com.example.submission1.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItemTv?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
) : Parcelable

@Parcelize
data class ResultsItemTv(

	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,
) : Parcelable
