package com.dicoding.movietvcatalogue.activity.favorite.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

class TvFavoriteViewModel(private val movieTvRepository: MovieTvRepository): ViewModel() {
    fun getTvFavorite(): LiveData<List<MovieTVEntity>> = movieTvRepository.getFavoriteTvShow()
}