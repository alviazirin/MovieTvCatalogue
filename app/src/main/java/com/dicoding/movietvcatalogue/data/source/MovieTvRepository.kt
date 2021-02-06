package com.dicoding.movietvcatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity

class MovieTvRepository(private val remoteDataSource: RemoteDataSource): MovieTvDataSource {

    companion object{
        @Volatile
        private var instance: MovieTvRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MovieTvRepository =
            instance ?: synchronized(this){
                instance ?: MovieTvRepository(remoteDataSource)
            }
    }

    private val basePosterUrl = "https://image.tmdb.org/t/p/original"
    private val _movieData = MutableLiveData<ArrayList<MovieTVEntity>>()
    private val _tvShowData = MutableLiveData<ArrayList<MovieTVEntity>>()
    private val _movieDetailData = MutableLiveData<MovieTvDetailEntity>()
    private val _tvShowDetailData = MutableLiveData<MovieTvDetailEntity>()

    override fun loadMovie(): List<MovieTVEntity> {
        val movieResponse = remoteDataSource.loadMovie()
        val movieList = ArrayList<MovieTVEntity>()
        for (movie in movieResponse){
            val movies = MovieTVEntity(movie.id,
            movie.title,
            movie.date,
            basePosterUrl+movie.poster)

            movieList.add(movies)
        }
        return movieList
    }

    override fun loadTvShow(): List<MovieTVEntity> {
        val tvResponse = remoteDataSource.loadTvShow()
        val tvShowList = ArrayList<MovieTVEntity>()
        for (tvShows in tvResponse){
            val tvShow = MovieTVEntity(tvShows.id,tvShows.title, tvShows.date, basePosterUrl+tvShows.poster)

            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    override fun loadDetailMovie(movieId: String): MovieTvDetailEntity {
        val detailMovie = remoteDataSource.loadDetailMovie(movieId)
        lateinit var movieTvDetailEntity: MovieTvDetailEntity
        movieTvDetailEntity = MovieTvDetailEntity(
            detailMovie.id,
            detailMovie.title,
            detailMovie.date,
            detailMovie.genre,
            detailMovie.productionCompanies,
            detailMovie.overview,
            detailMovie.homepage,
            basePosterUrl+detailMovie.poster
        )
        /*movieTvDetailEntity.id = detailMovie.id
        movieTvDetailEntity.title = detailMovie.title
        movieTvDetailEntity.year = detailMovie.date
        movieTvDetailEntity.genre = detailMovie.genre
        movieTvDetailEntity.overview = detailMovie.overview
        movieTvDetailEntity.producer = detailMovie.productionCompanies
        movieTvDetailEntity.url = detailMovie.homepage
        movieTvDetailEntity.poster = detailMovie.poster*/

        return movieTvDetailEntity
    }

    override fun loadDetailTvShow(tvShowId: String): MovieTvDetailEntity {
        val detailTvShow = remoteDataSource.loadDetailTvShow(tvShowId)
        lateinit var movieTvDetailEntity: MovieTvDetailEntity
        movieTvDetailEntity = MovieTvDetailEntity(
            detailTvShow.id,
            detailTvShow.title,
            detailTvShow.date,
            detailTvShow.genre,
            detailTvShow.productionCompanies,
            detailTvShow.overview,
            detailTvShow.homepage,
            basePosterUrl+detailTvShow.poster
        )

        return movieTvDetailEntity
    }

    override fun loadMovieApi(): LiveData<ArrayList<MovieTVEntity>> {
        val movieList = ArrayList<MovieTVEntity>()
        val movieData: LiveData<ArrayList<MovieTVEntity>> = _movieData


        remoteDataSource.loadMovieApi().observeForever(Observer{ movies ->
            for (movie in movies){
                val id = movie.id
                val title = movie.title
                val year = movie.releaseDate.split("-").toTypedArray()
                val date = year[0]
                val poster = basePosterUrl+movie.posterPath

                val mov = MovieTVEntity(id, title, date, poster)

                movieList.add(mov)
            }
            _movieData.value = movieList
        })
        return movieData
    }

    override fun loadTvShowApi(): LiveData<ArrayList<MovieTVEntity>>{
        val tvShowList = ArrayList<MovieTVEntity>()
        val tvShowData: LiveData<ArrayList<MovieTVEntity>> = _tvShowData

        remoteDataSource.loadTvShowApi().observeForever(Observer{ tvShows ->
            for (tvShow in tvShows){
                val id = tvShow.id
                val title = tvShow.name
                val year = tvShow.firstAirDate.split("-").toTypedArray()
                val date = year[0]
                val poster = basePosterUrl+tvShow.posterPath

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
            val genre = listGenre.joinToString(", ")
            val listComp = movieDetail.productionCompanies
            val producer = listComp.joinToString(", ")
            val overview = movieDetail.overview
            val url = movieDetail.homepage
            val poster = basePosterUrl+movieDetail.posterPath

            _movieDetailData.value = MovieTvDetailEntity(id, title, year, genre, producer, overview, url, poster)
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
            val genre = listGenre.joinToString(", ")
            val listComp = showsDetail.productionCompanies
            val producer = listComp.joinToString(", ")
            val overview = showsDetail.overview
            val url = showsDetail.homepage
            val poster = basePosterUrl+showsDetail.posterPath

            _tvShowDetailData.value = MovieTvDetailEntity(id, title, year, genre, producer, overview, url, poster)
        })
        return tvShowDetailData
    }


}