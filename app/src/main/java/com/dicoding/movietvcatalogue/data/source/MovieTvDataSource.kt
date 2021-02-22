package com.dicoding.movietvcatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.vo.Resource

interface MovieTvDataSource {

    fun loadMovieApi(sort: String): LiveData<Resource<PagedList<MovieTVEntity>>>

    fun loadTvShowApi(sort: String): LiveData<Resource<PagedList<MovieTVEntity>>>

    fun loadDetailMovieApi(movieId: String): LiveData<MovieTvDetailEntity>

    fun loadDetailTvShowApi(tvShowId: String): LiveData<MovieTvDetailEntity>

    fun getFavoriteMovie(): LiveData<List<MovieTVEntity>>

    fun getFavoriteTvShow(): LiveData<List<MovieTVEntity>>

    fun favorited(id: String)

    fun unfavorited(id: String)

}