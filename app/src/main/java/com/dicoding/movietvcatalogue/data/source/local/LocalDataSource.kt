package com.dicoding.movietvcatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.movietvcatalogue.data.source.local.database.MovieTvDao
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

class LocalDataSource(val movieTvDao: MovieTvDao) {
    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieTvDao: MovieTvDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieTvDao)
    }

    fun getDataMovie(): LiveData<List<MovieTVEntity>> = movieTvDao.getDataMovie()

    fun getDataTV(): LiveData<List<MovieTVEntity>> = movieTvDao.getDataTv()

    fun insertMovieTv(movieTvItems: ArrayList<MovieTVEntity>) = movieTvDao.insertMovieTv(movieTvItems)

    fun deleteMovieTv(movieTVEntity: MovieTVEntity) = movieTvDao.deleteMovieTv(movieTVEntity)
}