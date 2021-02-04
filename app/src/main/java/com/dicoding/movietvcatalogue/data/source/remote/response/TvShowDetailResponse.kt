package com.dicoding.movietvcatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("production_companies")
	val productionCompanies: List<ProductionCompaniesItemTvShow>,

	@field:SerializedName("genres")
	val genres: List<GenresItemTvShow>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("homepage")
	val homepage: String
)

data class GenresItemTvShow(

	@field:SerializedName("name")
	val name: String
)

data class ProductionCompaniesItemTvShow(

	@field:SerializedName("name")
	val name: String
)
