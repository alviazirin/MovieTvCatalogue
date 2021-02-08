package com.dicoding.movietvcatalogue.data.source

import androidx.lifecycle.LiveData
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity

interface MovieTvDataSource {

  fun loadMovieApi(): LiveData<ArrayList<MovieTVEntity>>

  fun loadTvShowApi(): LiveData<ArrayList<MovieTVEntity>>

  fun loadDetailMovieApi(movieId: String): LiveData<MovieTvDetailEntity>

  fun loadDetailTvShowApi(tvShowId: String): LiveData<MovieTvDetailEntity>
}