package com.dicoding.movietvcatalogue.main.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

class TvShowViewModel(private val movieTvRepository: MovieTvRepository): ViewModel() {
    fun getTvShow(): List<MovieTVEntity> = movieTvRepository.loadTvShow()
}