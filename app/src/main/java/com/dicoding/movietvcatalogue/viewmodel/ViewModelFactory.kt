package com.dicoding.movietvcatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.detail.DetailViewModel
import com.dicoding.movietvcatalogue.di.Injection
import com.dicoding.movietvcatalogue.main.movie.MoviesViewModel
import com.dicoding.movietvcatalogue.main.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val mMovieTvRepository: MovieTvRepository): ViewModelProvider.NewInstanceFactory() {

    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(mMovieTvRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(mMovieTvRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                return DetailViewModel(mMovieTvRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class:" +modelClass.name)
        }
    }
}