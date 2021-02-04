package com.dicoding.movietvcatalogue.data.source

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

    override fun loadMovie(): List<MovieTVEntity> {
        val movieResponse = remoteDataSource.loadMovie()
        val movieList = ArrayList<MovieTVEntity>()
        for (movie in movieResponse){
            val movies = MovieTVEntity(movie.id,
            movie.title,
            movie.date,
            movie.poster)

            movieList.add(movies)
        }
        return movieList
    }

    override fun loadTvShow(): List<MovieTVEntity> {
        val tvResponse = remoteDataSource.loadTvShow()
        val tvShowList = ArrayList<MovieTVEntity>()
        for (tvShows in tvResponse){
            val tvShow = MovieTVEntity(tvShows.id,tvShows.title, tvShows.date, tvShows.poster)

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
            detailMovie.poster
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
            detailTvShow.poster
        )

        return movieTvDetailEntity
    }

}