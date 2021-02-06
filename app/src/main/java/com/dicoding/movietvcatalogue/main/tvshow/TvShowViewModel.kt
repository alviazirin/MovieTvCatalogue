package com.dicoding.movietvcatalogue.main.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

class TvShowViewModel(private val movieTvRepository: MovieTvRepository): ViewModel() {
    private val _tvShowData = MutableLiveData<ArrayList<MovieTVEntity>>()
    val tvShowData: LiveData<ArrayList<MovieTVEntity>> = _tvShowData

    fun fetchTvShow(){
        val tvShowList = ArrayList<MovieTVEntity>()

        movieTvRepository.loadTvShowApi().observeForever(Observer { tvShows ->
            for (tvShow in tvShows){
                val show = MovieTVEntity(tvShow.id, tvShow.title, tvShow.date, tvShow.poster)

                tvShowList.add(show)
            }
            _tvShowData.value = tvShowList
        })
    }

    fun getTvShow(): LiveData<ArrayList<MovieTVEntity>> {
        return tvShowData
    }
}