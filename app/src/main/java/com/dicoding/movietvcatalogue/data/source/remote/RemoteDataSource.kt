package com.dicoding.movietvcatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.movietvcatalogue.api.ApiConfig
import com.dicoding.movietvcatalogue.data.source.remote.response.*
import com.dicoding.movietvcatalogue.utils.EspressoIdlingResource
import com.dicoding.movietvcatalogue.utils.JsonHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val jsonHelper: JsonHelper) {

    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource(helper)
            }
    }
    private val connError = "ConnError"
    private val msg = "Please Check Connection"

    fun loadMovie(): List<MovieTvResponse> = jsonHelper.loadMovie()

    fun loadTvShow(): List<MovieTvResponse> = jsonHelper.loadTvShow()

    fun loadDetailMovie(movieId: String): MovieTvDetailResponse = jsonHelper.loadDetailMovie(movieId)

    fun loadDetailTvShow(tvShowId: String): MovieTvDetailResponse = jsonHelper.loadDetailTvShow(tvShowId)

    fun loadMovieApi(): LiveData<ArrayList<ResultsMovieItem>>{
        val movies = MutableLiveData<ArrayList<ResultsMovieItem>>()
        val client = ApiConfig.getMovieService().getMovie()
        EspressoIdlingResource.increment()
        client.enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
               if (response.isSuccessful){
                    val responseBody = response.body()

                   if (responseBody != null){
                        movies.value = responseBody.results
                       EspressoIdlingResource.decrement()
                   } else {
                       Log.d(connError, msg)
                   }
               } else {
                   Log.d(connError, msg)
               }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d(connError, msg)
            }
        })
        return movies
    }

    fun loadTvShowApi(): LiveData<ArrayList<ResultsTvShowItem>>{
        val shows = MutableLiveData<ArrayList<ResultsTvShowItem>>()
        val client = ApiConfig.getTvShowService().getTvShow()
        EspressoIdlingResource.increment()
        client.enqueue(object : Callback<TvShowResponse>{
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){
                        shows.value = responseBody.results
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.d(connError, msg)
                    }
                } else {
                    Log.d(connError, msg)
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d(connError, msg)
                Log.d(connError, t.message.toString())
            }
        })
        return shows
    }

    fun loadMovieDetailApi(movieId: String): LiveData<MovieDetailResponse>{
        val detail = MutableLiveData<MovieDetailResponse>()
        EspressoIdlingResource.increment()
        val client = ApiConfig.getMovieDetailService().getDetailMovie(movieId)
        client.enqueue(object : Callback<MovieDetailResponse>{
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){
                        detail.value = responseBody
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.d(connError, msg)
                    }
                } else {
                    Log.d(connError, msg)
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.d(connError, msg)
                Log.d(connError, t.message.toString())
            }
        })
        return detail
    }

    fun loadTvShowDetailApi(tvShowId: String): LiveData<TvShowDetailResponse> {
        val detail = MutableLiveData<TvShowDetailResponse>()
        EspressoIdlingResource.increment()
        val client = ApiConfig.getTvShowDetailService().getDetailTvShow(tvShowId)
        client.enqueue(object : Callback<TvShowDetailResponse>{
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()

                    if (responseBody != null){
                        detail.value = responseBody
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.d(connError, msg)
                    }
                } else {
                    Log.d(connError, msg)
                }
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.d(connError, msg)
                Log.d(connError, t.message.toString())
            }
        })
        return detail
    }
}