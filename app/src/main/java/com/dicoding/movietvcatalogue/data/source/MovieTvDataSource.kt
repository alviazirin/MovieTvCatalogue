package com.dicoding.movietvcatalogue.data.source

import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity

interface MovieTvDataSource {
  fun loadMovie(): List<MovieTVEntity>

  fun loadTvShow(): List<MovieTVEntity>

  fun loadDetailMovie(movieId: String): MovieTvDetailEntity

  fun loadDetailTvShow(tvShowId: String): MovieTvDetailEntity
}