package com.dicoding.movietvcatalogue.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

class DetailViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    private val _movieDetailData = MutableLiveData<MovieTvDetailEntity>()
    val movieDetailData: LiveData<MovieTvDetailEntity> = _movieDetailData
    private val _tvShowDetailData = MutableLiveData<MovieTvDetailEntity>()
    val tvShowDetailData: LiveData<MovieTvDetailEntity> = _tvShowDetailData

    fun fetchDetailMovie(movieId: String){
        movieTvRepository.loadDetailMovieApi(movieId).observeForever(Observer { movieDetail ->
            _movieDetailData.value = movieDetail
        })
    }

    fun fetchDetailTvShow(tvShowId: String){
        movieTvRepository.loadDetailTvShowApi(tvShowId).observeForever(Observer { tvShowDetail ->
            _tvShowDetailData.value = tvShowDetail
        })
    }

    fun getDetailMovie(): LiveData<MovieTvDetailEntity> {
        return movieDetailData
    }

    fun getDetailTvShow(): LiveData<MovieTvDetailEntity> {
        return tvShowDetailData
    }
}