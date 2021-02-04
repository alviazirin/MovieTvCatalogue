package com.dicoding.movietvcatalogue.data.source.remote

import com.dicoding.movietvcatalogue.data.source.remote.response.MovieTvDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieTvResponse
import com.dicoding.movietvcatalogue.utils.JsonHelper

class RemoteDataSource(private val jsonHelper: JsonHelper) {

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper)
            }
    }

    fun loadMovie(): List<MovieTvResponse> = jsonHelper.loadMovie()

    fun loadTvShow(): List<MovieTvResponse> = jsonHelper.loadTvShow()

    fun loadDetailMovie(movieId: String): MovieTvDetailResponse = jsonHelper.loadDetailMovie(movieId)

    fun loadDetailTvShow(tvShowId: String): MovieTvDetailResponse = jsonHelper.loadDetailTvShow(tvShowId)
}