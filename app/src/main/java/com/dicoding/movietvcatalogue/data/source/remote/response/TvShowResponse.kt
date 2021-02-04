package com.dicoding.movietvcatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(

	@field:SerializedName("results")
	val results: List<ResultsTvShowItem>
)

data class ResultsTvShowItem(

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("poster_path")
	val posterPath: String
)
