package com.dicoding.movietvcatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.movietvcatalogue.data.source.remote.response.ResultsMovieItem
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity

interface MovieTvDataSource {
  fun loadMovie(): List<MovieTVEntity>

  fun loadTvShow(): List<MovieTVEntity>

  fun loadDetailMovie(movieId: String): MovieTvDetailEntity

  fun loadDetailTvShow(tvShowId: String): MovieTvDetailEntity

  fun loadMovieApi(): LiveData<ArrayList<MovieTVEntity>>

  fun loadTvShowApi(): LiveData<ArrayList<MovieTVEntity>>

  fun loadDetailMovieApi(movieId: String): LiveData<MovieTvDetailEntity>

  fun loadDetailTvShowApi(tvShowId: String): LiveData<MovieTvDetailEntity>
}