package com.dicoding.movietvcatalogue.di

import android.content.Context
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieTvRepository{

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieTvRepository.getInstance(remoteDataSource)

    }
}