package com.dicoding.movietvcatalogue.activity.main.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy
import com.dicoding.movietvcatalogue.vo.Resource

class MoviesViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {
    private val _moviesData = MutableLiveData<ArrayList<MovieTVEntity>>()
    private val moviesData: LiveData<ArrayList<MovieTVEntity>> = _moviesData
    /*fun fetchMovie(): LiveData<ArrayList<MovieTVEntity>> {
        val movieList = ArrayList<MovieTVEntity>()

        movieTvRepository.loadMovieApi().observeForever(Observer { movies ->
            for (movie in movies) {
                val mov = MovieTVEntity(movie.id, movie.title, movie.date, movie.poster)

                movieList.add(mov)
            }
            _moviesData.value = movieList
        })
        return moviesData
    }*/

    //fun getdaMovie(): LiveData<Resource<ArrayList<MovieTVEntity>>> = movieTvRepository.loadMovieApi()

    fun getMovie(): LiveData<Resource<PagedList<MovieTVEntity>>> = movieTvRepository.loadMovieApi()

    fun getNull(): List<MovieTvDetailEntity> = DataDummy.generateNullTest()
}