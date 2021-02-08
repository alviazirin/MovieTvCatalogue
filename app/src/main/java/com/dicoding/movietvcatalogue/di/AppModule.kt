package com.dicoding.movietvcatalogue.di

import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.detail.DetailViewModel
import com.dicoding.movietvcatalogue.main.movie.MoviesViewModel
import com.dicoding.movietvcatalogue.main.tvshow.TvShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    single { RemoteDataSource() }

    single { MovieTvRepository(get()) }
}

val viewModelModule = module {
    viewModel { MoviesViewModel(get()) }

    viewModel { TvShowViewModel(get()) }

    viewModel { DetailViewModel(get()) }
}