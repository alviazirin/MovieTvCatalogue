package com.dicoding.movietvcatalogue.activity.main.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.vo.Resource

class TvShowViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    private val _tvShowData = MutableLiveData<ArrayList<MovieTVEntity>>()
    private val tvShowData: LiveData<ArrayList<MovieTVEntity>> = _tvShowData

    fun getTvShow(sort: String): LiveData<Resource<PagedList<MovieTVEntity>>> =
        movieTvRepository.loadTvShowApi(sort)
}