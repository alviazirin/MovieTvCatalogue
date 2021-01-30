package com.dicoding.movietvcatalogue.detail

import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

class DetailViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    fun getDetailMovie(movieId: String): MovieTvDetailEntity = movieTvRepository.loadDetailMovie(movieId)
    fun getDetailTvShow(tvShowId: String): MovieTvDetailEntity = movieTvRepository.loadDetailTvShow(tvShowId)
}