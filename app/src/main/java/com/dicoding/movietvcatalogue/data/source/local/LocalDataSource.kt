package com.dicoding.movietvcatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.movietvcatalogue.data.source.local.database.MovieTvDao
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.SortUtils

class LocalDataSource(val movieTvDao: MovieTvDao) {

    fun getDataMovie(sort: String): DataSource.Factory<Int, MovieTVEntity> {
        val query = SortUtils.getSortedMovieQuery(sort)
        return movieTvDao.getDataMovie(query)
    }

    fun getDataTV(sort: String): DataSource.Factory<Int, MovieTVEntity> {
        val query = SortUtils.getSortedTvShowQuery(sort)
        return movieTvDao.getDataTv(query)
    }

    fun insertMovieTv(movieTvItems: ArrayList<MovieTVEntity>) =
        movieTvDao.insertMovieTv(movieTvItems)

    fun favorited(id: String) = movieTvDao.favorited(id)

    fun unfavorited(id: String) = movieTvDao.unfavorited(id)

    fun getFavoriteMovie(): LiveData<List<MovieTVEntity>> = movieTvDao.getFavoriteMovie()

    fun getFavoriteTvShow(): LiveData<List<MovieTVEntity>> = movieTvDao.getFavoriteTv()
}