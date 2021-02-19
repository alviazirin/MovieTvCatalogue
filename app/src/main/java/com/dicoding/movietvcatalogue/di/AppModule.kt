package com.dicoding.movietvcatalogue.di

import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.data.source.local.LocalDataSource
import com.dicoding.movietvcatalogue.data.source.local.database.MovieTvDatabase
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.activity.detail.DetailViewModel
import com.dicoding.movietvcatalogue.activity.favorite.movie.MovieFavoriteViewModel
import com.dicoding.movietvcatalogue.activity.favorite.tv.TvFavoriteViewModel
import com.dicoding.movietvcatalogue.activity.main.movie.MoviesViewModel
import com.dicoding.movietvcatalogue.activity.main.tvshow.TvShowViewModel
import com.dicoding.movietvcatalogue.utils.AppExecutors
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    single { RemoteDataSource() }

    single { MovieTvRepository(get(),get(),get()) }
}

val roomModule = module {

    single { MovieTvDatabase.getInstance(get()) }

    single { get<MovieTvDatabase>().movieTvDao() }

    single { LocalDataSource(get()) }

    single { AppExecutors() }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }

    viewModel { TvShowViewModel(get()) }

    viewModel { DetailViewModel(get()) }

    viewModel { MovieFavoriteViewModel(get()) }

    viewModel { TvFavoriteViewModel(get()) }
}