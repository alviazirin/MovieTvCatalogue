package com.dicoding.movietvcatalogue.main.movie

import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

class MoviesViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    fun getMoviesSimple(): List<MovieTVEntity> = movieTvRepository.loadMovie()
    //fun getMovies(): List<MovieTvDetailEntity> = DataDummy.generateDummyDetailMovie()
    fun getNull(): List<MovieTvDetailEntity> = DataDummy.generateNullTest()
}