package com.dicoding.movietvcatalogue.api

import com.dicoding.movietvcatalogue.BuildConfig
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    companion object {
        private const val API_KEY = BuildConfig.API_KEY
    }

    @GET("movie/upcoming")
    fun getMovie(@Query("api_key") apikey: String = API_KEY): Call<MovieResponse>

    @GET("tv/popular")
    fun getTvShow(@Query("api_key") apikey: String = API_KEY): Call<TvShowResponse>


    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") id: String,
        @Query("api_key") apikey: String = API_KEY
    ): Call<MovieDetailResponse>


    @GET("tv/{id}")
    fun getDetailTvShow(
        @Path("id") id: String,
        @Query("api_key") apikey: String = API_KEY
    ): Call<TvShowDetailResponse>
}