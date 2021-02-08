package com.dicoding.movietvcatalogue.main.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

class MoviesViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    private val _moviesData = MutableLiveData<ArrayList<MovieTVEntity>>()
    private val moviesData: LiveData<ArrayList<MovieTVEntity>> = _moviesData
    fun fetchMovie(): LiveData<ArrayList<MovieTVEntity>> {
        val movieList = ArrayList<MovieTVEntity>()

        movieTvRepository.loadMovieApi().observeForever(Observer { movies ->
            for (movie in movies) {
                val mov = MovieTVEntity(movie.id, movie.title, movie.date, movie.poster)

                movieList.add(mov)
            }
            _moviesData.value = movieList
        })
        return moviesData
    }

    fun getMovie(): LiveData<ArrayList<MovieTVEntity>> {
        return moviesData
    }

    fun getNull(): List<MovieTvDetailEntity> = DataDummy.generateNullTest()
}