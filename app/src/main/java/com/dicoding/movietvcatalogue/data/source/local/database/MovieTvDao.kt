package com.dicoding.movietvcatalogue.data.source.local.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

@Dao
interface MovieTvDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieTv(movieTvItems: ArrayList<MovieTVEntity>)

    @Delete
    fun deleteMovieTv(movieTVItem: MovieTVEntity)

    @RawQuery(observedEntities = [MovieTVEntity::class])
    fun getDataMovie(query: SupportSQLiteQuery): DataSource.Factory<Int, MovieTVEntity>

    @RawQuery(observedEntities = [MovieTVEntity::class])
    fun getDataTv(query: SupportSQLiteQuery): DataSource.Factory<Int, MovieTVEntity>

    @Query("UPDATE movietventity SET favorite = 1 WHERE id = :id")
    fun favorited(id: String)

    @Query("UPDATE movietventity SET favorite = 0 WHERE id = :id")
    fun unfavorited(id: String)

    @Query("SELECT * FROM movietventity WHERE type = 1 AND favorite = 1 ORDER BY title DESC")
    fun getFavoriteMovie(): LiveData<List<MovieTVEntity>>

    @Query("SELECT * FROM movietventity WHERE type = 2 AND favorite = 1 ORDER BY title DESC")
    fun getFavoriteTv(): LiveData<List<MovieTVEntity>>
}