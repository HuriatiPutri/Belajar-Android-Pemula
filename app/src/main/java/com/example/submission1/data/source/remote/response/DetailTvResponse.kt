package com.example.submission1.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailTvResponse(
	@field:SerializedName("original_language")
	val originalLanguage: String? = null,
	@field:SerializedName("number_of_episodes")
	val numberOfEpisodes: Int? = null,
	val networks: List<NetworksItem?>? = null,
	val type: String? = null,
	val backdropPath: String? = null,
	val genres: List<GenresItemTv?>? = null,
	val popularity: Double? = null,
	val id: Int,
	@field:SerializedName("number_of_seasons")
	val numberOfSeasons: Int? = null,
	val voteCount: Int? = null,
	val firstAirDate: String? = null,
	val overview: String? = null,
	val seasons: List<SeasonsItem?>? = null,
	val languages: List<String?>? = null,
	val createdBy: List<CreatedByItem?>? = null,
	val lastEpisodeToAir: LastEpisodeToAir? = null,
	@field:SerializedName("poster_path")
	val posterPath: String? = null,
	val originCountry: List<String?>? = null,
	val spokenLanguages: List<SpokenLanguagesItemTv?>? = null,
	@field:SerializedName("original_name")
	val originalName: String? = null,
	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,
	val name: String? = null,
	val tagline: String? = null,
	val episodeRunTime: List<Int?>? = null,
	val nextEpisodeToAir: String? = null,
	val inProduction: Boolean? = null,
	val lastAirDate: String? = null,
	val homepage: String? = null,
	val status: String? = null
) : Parcelable

@Parcelize
data class LastEpisodeToAir(
	val productionCode: String? = null,
	val airDate: String? = null,
	val overview: String? = null,
	val episodeNumber: Int? = null,
	val voteAverage: Double? = null,
	val name: String? = null,
	val seasonNumber: Int? = null,
	val id: Int? = null,
	val stillPath: String? = null,
	val voteCount: Int? = null
) : Parcelable

@Parcelize
data class NetworksItem(
	val logoPath: String? = null,
	val name: String? = null,
	val id: Int? = null,
	val originCountry: String? = null
) : Parcelable

@Parcelize
data class SeasonsItem(
	val airDate: String? = null,
	val overview: String? = null,
	val episodeCount: Int? = null,
	val name: String? = null,
	val seasonNumber: Int? = null,
	val id: Int? = null,
	val posterPath: String? = null
) : Parcelable

@Parcelize
data class CreatedByItem(
	val gender: Int? = null,
	val creditId: String? = null,
	val name: String? = null,
	val profilePath: String? = null,
	val id: Int? = null
) : Parcelable

@Parcelize
data class SpokenLanguagesItemTv(
	val name: String? = null,
	val iso6391: String? = null,
	val englishName: String? = null
) : Parcelable

@Parcelize
data class GenresItemTv(
	val name: String? = null,
	val id: Int? = null
) : Parcelable
