package com.dicoding.movietvcatalogue.api

import com.dicoding.movietvcatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("?api_key=8102939096862fe3acc4ca8ff7109131")
    fun getMovie():Call<MovieResponse>

    @Headers("?api_key=8102939096862fe3acc4ca8ff7109131")
    fun getTvShow(): Call<TvShowResponse>

    @Headers("?api_key=8102939096862fe3acc4ca8ff7109131")
    @GET("movie/{id}")
    fun getDetailMovie(@Path("id") id: String): Call<MovieDetailResponse>

    @Headers("?api_key=8102939096862fe3acc4ca8ff7109131")
    @GET("tv/{id}")
    fun getDetailTvShow(@Path("id") id: String): Call<TvShowDetailResponse>
}