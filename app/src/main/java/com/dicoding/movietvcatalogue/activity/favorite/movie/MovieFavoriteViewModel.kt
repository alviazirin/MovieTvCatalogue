package com.dicoding.movietvcatalogue.activity.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

class MovieFavoriteViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    fun getMovie(): LiveData<List<MovieTVEntity>> = movieTvRepository.getFavoriteMovie()
}