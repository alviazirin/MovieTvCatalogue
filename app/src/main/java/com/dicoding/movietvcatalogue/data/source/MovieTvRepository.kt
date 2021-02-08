package com.dicoding.movietvcatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity

class MovieTvRepository(private val remoteDataSource: RemoteDataSource) : MovieTvDataSource {


    private val basePosterUrl = "https://image.tmdb.org/t/p/original"
    private val _movieData = MutableLiveData<ArrayList<MovieTVEntity>>()
    private val _tvShowData = MutableLiveData<ArrayList<MovieTVEntity>>()
    private val _movieDetailData = MutableLiveData<MovieTvDetailEntity>()
    private val _tvShowDetailData = MutableLiveData<MovieTvDetailEntity>()


    override fun loadMovieApi(): LiveData<ArrayList<MovieTVEntity>> {
        val movieList = ArrayList<MovieTVEntity>()
        val movieData: LiveData<ArrayList<MovieTVEntity>> = _movieData


        remoteDataSource.loadMovieApi().observeForever(Observer { movies ->
            for (movie in movies) {
                val id = movie.id
                val title = movie.title
                val year = movie.releaseDate.split("-").toTypedArray()
                val date = year[0]
                val poster = basePosterUrl + movie.posterPath

                val mov = MovieTVEntity(id, title, date, poster)

                movieList.add(mov)
            }
            _movieData.value = movieList
        })
        return movieData
    }

    override fun loadTvShowApi(): LiveData<ArrayList<MovieTVEntity>> {
        val tvShowList = ArrayList<MovieTVEntity>()
        val tvShowData: LiveData<ArrayList<MovieTVEntity>> = _tvShowData

        remoteDataSource.loadTvShowApi().observeForever(Observer { tvShows ->
            for (tvShow in tvShows) {
                val id = tvShow.id
                val title = tvShow.name
                val year = tvShow.firstAirDate.split("-").toTypedArray()
                val date = year[0]
                val poster = basePosterUrl + tvShow.posterPath

                val show = MovieTVEntity(id, title, date, poster)

                tvShowList.add(show)
            }
            _tvShowData.value = tvShowList
        })
        return tvShowData
    }

    override fun loadDetailMovieApi(movieId: String): LiveData<MovieTvDetailEntity> {
        val movieDetailData: LiveData<MovieTvDetailEntity> = _movieDetailData

        remoteDataSource.loadMovieDetailApi(movieId).observeForever(Observer { movieDetail ->
            val id = movieDetail.id
            val title = movieDetail.title
            val date = movieDetail.releaseDate.split("-").toTypedArray()
            val year = date[0]
            val listGenre = movieDetail.genres
            val genreNames = ArrayList<String>()
            for (genre in listGenre) {
                val genreName = genre.name

                genreNames.add(genreName)
            }
            val genres = genreNames.joinToString(", ")
            val listComp = movieDetail.productionCompanies
            val compNames = ArrayList<String>()
            for (company in listComp) {
                val compName = company.name

                compNames.add(compName)
            }
            val producer = compNames.joinToString(", ")
            val overview = movieDetail.overview
            val url = movieDetail.homepage
            val poster = basePosterUrl + movieDetail.posterPath

            _movieDetailData.value =
                MovieTvDetailEntity(id, title, year, genres, producer, overview, url, poster)
        })
        return movieDetailData
    }

    override fun loadDetailTvShowApi(tvShowId: String): LiveData<MovieTvDetailEntity> {
        val tvShowDetailData: LiveData<MovieTvDetailEntity> = _tvShowDetailData

        remoteDataSource.loadTvShowDetailApi(tvShowId).observeForever(Observer { showsDetail ->
            val id = showsDetail.id
            val title = showsDetail.name
            val date = showsDetail.firstAirDate.split("-").toTypedArray()
            val year = date[0]
            val listGenre = showsDetail.genres
            val genreNames = ArrayList<String>()
            for (genre in listGenre) {
                val genreName = genre.name

                genreNames.add(genreName)
            }
            val genre = genreNames.joinToString(", ")
            val listComp = showsDetail.productionCompanies
            val compNames = ArrayList<String>()
            for (company in listComp) {
                val compName = company.name

                compNames.add(compName)
            }
            val producer = compNames.joinToString(", ")
            val overview = showsDetail.overview
            val url = showsDetail.homepage
            val poster = basePosterUrl + showsDetail.posterPath

            _tvShowDetailData.value =
                MovieTvDetailEntity(id, title, year, genre, producer, overview, url, poster)
        })
        return tvShowDetailData
    }


}