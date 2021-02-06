package com.dicoding.movietvcatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("release_date")
	val releaseDate: String,

	@field:SerializedName("genres")
	val genres: ArrayList<GenresItemMovie>,

	@field:SerializedName("production_companies")
	val productionCompanies: ArrayList<ProductionCompaniesItemMovie>,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("homepage")
	val homepage: String,

	@field:SerializedName("poster_path")
	val posterPath: String
)

data class GenresItemMovie(

	@field:SerializedName("name")
	val name: String
)

data class ProductionCompaniesItemMovie(

	@field:SerializedName("name")
	val name: String
)
