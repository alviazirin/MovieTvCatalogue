package com.dicoding.movietvcatalogue.data.source.local.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

@Dao
interface MovieTvDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieTv(movieTvItems: ArrayList<MovieTVEntity>)

    @Delete
    fun deleteMovieTv(movieTVItem: MovieTVEntity)

    @Query("SELECT * FROM movietventity WHERE type = 1 ORDER BY title DESC")
    fun getDataMovie(): LiveData<List<MovieTVEntity>>

    @Query("SELECT * FROM movietventity WHERE type = 2 ORDER BY title DESC")
    fun getDataTv(): LiveData<List<MovieTVEntity>>
}