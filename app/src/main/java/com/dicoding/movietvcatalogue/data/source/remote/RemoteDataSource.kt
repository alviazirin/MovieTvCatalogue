package com.dicoding.movietvcatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.movietvcatalogue.api.ApiConfig
import com.dicoding.movietvcatalogue.data.source.remote.response.*
import com.dicoding.movietvcatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    private val connError = "ConnError"
    private val msg = "Please Check Connection"


    fun loadMovieApi(): LiveData<ApiResponse<ArrayList<ResultsMovieItem>>> {
        val movies = MutableLiveData<ApiResponse<ArrayList<ResultsMovieItem>>>()
        val client = ApiConfig.getAPIService().getMovie()
        EspressoIdlingResource.increment()
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        movies.value = ApiResponse.success(responseBody.results)
                        EspressoIdlingResource.decrement()
                    } else {
                        ApiResponse.empty(msg, null)
                    }
                } else {
                    ApiResponse.empty(msg, null)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                ApiResponse.error(msg, null)
            }
        })
        return movies
    }

    fun loadTvShowApi(): LiveData<ApiResponse<ArrayList<ResultsTvShowItem>>> {
        val shows = MutableLiveData<ApiResponse<ArrayList<ResultsTvShowItem>>>()
        val client = ApiConfig.getAPIService().getTvShow()
        EspressoIdlingResource.increment()
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        shows.value = ApiResponse.success(responseBody.results)
                        EspressoIdlingResource.decrement()
                    } else {
                        ApiResponse.empty(msg, null)
                    }
                } else {
                    ApiResponse.empty(msg, null)
                }
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d(connError, msg)
                Log.d(connError, t.message.toString())
                ApiResponse.error(msg, null)
            }
        })
        return shows
    }

    fun loadMovieDetailApi(movieId: String): LiveData<ApiResponse<MovieDetailResponse>> {
        val detail = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        EspressoIdlingResource.increment()
        val client = ApiConfig.getAPIService().getDetailMovie(movieId)
        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        detail.value = ApiResponse.success(responseBody)
                        EspressoIdlingResource.decrement()
                    } else {
                        ApiResponse.empty(msg, null)
                    }
                } else {
                    ApiResponse.empty(msg, null)
                }
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.d(connError, msg)
                Log.d(connError, t.message.toString())
                ApiResponse.error(msg, null)
            }
        })
        return detail
    }

    fun loadTvShowDetailApi(tvShowId: String): LiveData<ApiResponse<TvShowDetailResponse>> {
        val detail = MutableLiveData<ApiResponse<TvShowDetailResponse>>()
        EspressoIdlingResource.increment()
        val client = ApiConfig.getAPIService().getDetailTvShow(tvShowId)
        client.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        detail.value = ApiResponse.success(responseBody)
                        EspressoIdlingResource.decrement()
                    } else {
                        ApiResponse.empty(msg, null)
                    }
                } else {
                    ApiResponse.empty(msg, null)
                }
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.d(connError, msg)
                Log.d(connError, t.message.toString())
                ApiResponse.error(msg, null)
            }
        })
        return detail
    }
}