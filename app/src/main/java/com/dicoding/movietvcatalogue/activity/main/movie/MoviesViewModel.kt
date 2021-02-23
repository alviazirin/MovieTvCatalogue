package com.dicoding.movietvcatalogue.activity.main.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy
import com.dicoding.movietvcatalogue.vo.Resource

class MoviesViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {

    fun getMovie(sort: String): LiveData<Resource<PagedList<MovieTVEntity>>> =
        movieTvRepository.loadMovieApi(sort)

    fun getNull(): List<MovieTvDetailEntity> = DataDummy.generateNullTest()
}