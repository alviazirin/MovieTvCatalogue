package com.dicoding.movietvcatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(

	@field:SerializedName("results")
	val results: ArrayList<ResultsTvShowItem>
)

data class ResultsTvShowItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("poster_path")
	val posterPath: String
)
