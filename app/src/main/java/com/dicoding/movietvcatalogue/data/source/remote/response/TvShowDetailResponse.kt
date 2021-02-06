package com.dicoding.movietvcatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("genres")
	val genres: ArrayList<GenresItemTvShow>,

	@field:SerializedName("production_companies")
	val productionCompanies: ArrayList<ProductionCompaniesItemTvShow>,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("homepage")
	val homepage: String,

	@field:SerializedName("poster_path")
	val posterPath: String
)

data class GenresItemTvShow(

	@field:SerializedName("name")
	val name: String
)

data class ProductionCompaniesItemTvShow(

	@field:SerializedName("name")
	val name: String
)
