package com.dicoding.movietvcatalogue.api

import com.dicoding.movietvcatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/upcoming")
    fun getMovie(@Query("api_key") apikey:String = "8102939096862fe3acc4ca8ff7109131"):Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShow(@Query("api_key") apikey:String = "8102939096862fe3acc4ca8ff7109131"): Call<TvShowResponse>


    @GET("movie/{id}")
    fun getDetailMovie(@Path("id") id: String, @Query("api_key") apikey:String = "8102939096862fe3acc4ca8ff7109131"): Call<MovieDetailResponse>


    @GET("tv/{id}")
    fun getDetailTvShow(@Path("id") id: String, @Query("api_key") apikey:String = "8102939096862fe3acc4ca8ff7109131"): Call<TvShowDetailResponse>
}