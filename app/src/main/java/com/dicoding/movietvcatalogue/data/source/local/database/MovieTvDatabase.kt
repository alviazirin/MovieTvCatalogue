package com.dicoding.movietvcatalogue.data.source.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.movietvcatalogue.data.source.local.entity.MovieTvLocalEntity
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

@Database(entities = [MovieTVEntity::class], version = 1, exportSchema = false)
abstract class MovieTvDatabase : RoomDatabase() {
    abstract fun movieTvDao(): MovieTvDao

    companion object{
        @Volatile
        private var INSTANCE: MovieTvDatabase? = null

        fun getInstance(context: Context): MovieTvDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                MovieTvDatabase::class.java,
                "MovieTv.db").build()
            }
    }
}