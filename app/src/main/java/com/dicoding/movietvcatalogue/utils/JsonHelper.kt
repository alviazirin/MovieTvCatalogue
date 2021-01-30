package com.dicoding.movietvcatalogue.utils

import android.content.Context
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieTvDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieTvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private val basePosterUrl = "https://image.tmdb.org/t/p/original"
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (e: IOException){
            e.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieTvResponse>{
        val list = ArrayList<MovieTvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("popularMovie.json").toString())
            val listMovie = responseObject.getJSONArray("results")
            for (i in 0 until listMovie.length()){
                val movie = listMovie.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val date = movie.getString("release_date")
                val year = date.split("-").toTypedArray()
                val posterPath = movie.getString("poster_path")
                val poster = basePosterUrl+posterPath

                val movieTvResponse = MovieTvResponse(id.toInt(),title, year[0], poster)
                list.add(movieTvResponse)
            }
        } catch (e: JSONException){
            e.printStackTrace()
        }
        return  list
    }

    fun loadTvShow(): List<MovieTvResponse>{
        val list = ArrayList<MovieTvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("popularTvShow.json").toString())
            val listTvShow = responseObject.getJSONArray("results")
            for (i in 0 until listTvShow.length()){
                val tvShow = listTvShow.getJSONObject(i)

                val id = tvShow.getString("id")
                val title = tvShow.getString("original_name")
                val date = tvShow.getString("first_air_date")
                val year = date.split("-").toTypedArray()
                val posterPath = tvShow.getString("poster_path")
                val poster = basePosterUrl+posterPath

                val movieTvResponse = MovieTvResponse(id.toInt(),title, year[0], poster)
                list.add(movieTvResponse)
            }
        } catch (e: JSONException){
            e.printStackTrace()
        }
        return list
    }

    fun loadDetailMovie(movieId: String): MovieTvDetailResponse{
        val filename = "${movieId}.json"
        var movieTvDetailResponse: MovieTvDetailResponse? = null

        try {
            val result = parsingFileToString(filename)
            if (result != null){
                val genre = ArrayList<String>()
                val productionCompanies = ArrayList<String>()

                val responseObject = JSONObject(result)
                val id = responseObject.getString("id")
                val title = responseObject.getString("original_title")
                val date = responseObject.getString("release_date")
                val year = date.split("-").toTypedArray()
                val listGenres = responseObject.getJSONArray("genres")
                for (i in 0 until listGenres.length()){
                    val genres = listGenres.getJSONObject(i)

                    val genreName = genres.getString("name")
                    genre.add(genreName)
                }
                val listProduction = responseObject.getJSONArray("production_companies")
                for (i in 0 until listProduction.length()){
                    val productions = listProduction.getJSONObject(i)

                    val productionCompany = productions.getString("name")
                    productionCompanies.add(productionCompany)
                }
                val overview = responseObject.getString("overview")
                val homepage = responseObject.getString("homepage")
                val posterPath = responseObject.getString("poster_path")
                val poster = basePosterUrl+posterPath
                movieTvDetailResponse = MovieTvDetailResponse(id.toInt(),title,year[0],genre.joinToString(", "),productionCompanies.joinToString(", "),overview, homepage, poster)
            }
        } catch (e: JSONException){
            e.printStackTrace()
        }
        return movieTvDetailResponse as MovieTvDetailResponse
    }

    fun loadDetailTvShow(tvShowId: String): MovieTvDetailResponse{
        val fileName = "${tvShowId}.json"
        var movieTvDetailResponse: MovieTvDetailResponse? = null

        try {
            val result = parsingFileToString(fileName)
            if (result != null){
                val genre = ArrayList<String>()
                val productionCompanies = ArrayList<String>()

                val responseObject = JSONObject(result)
                val id = responseObject.getString("id")
                val title = responseObject.getString("original_name")
                val date = responseObject.getString("first_air_date")
                val year = date.split("-").toTypedArray()
                val listGenre = responseObject.getJSONArray("genres")
                for (i in 0 until listGenre.length()){
                    val genres = listGenre.getJSONObject(i)

                    val genreName = genres.getString("name")
                    genre.add(genreName)
                }
                val production = responseObject.getJSONArray("production_companies")
                for (i in 0 until production.length()){
                    val productionCompanyList = production.getJSONObject(i)

                    val productionName = productionCompanyList.getString("name")
                    productionCompanies.add(productionName)
                }
                val overview = responseObject.getString("overview")
                val homepage = responseObject.getString("homepage")
                val posterPath = responseObject.getString("poster_path")
                val poster = basePosterUrl+posterPath
                movieTvDetailResponse = MovieTvDetailResponse(id.toInt(),title,year[0],genre.joinToString(", "),productionCompanies.joinToString(", "),overview, homepage, poster)
            }
        } catch (e: JSONException){
            e.printStackTrace()
        }
        return movieTvDetailResponse as MovieTvDetailResponse
    }
}