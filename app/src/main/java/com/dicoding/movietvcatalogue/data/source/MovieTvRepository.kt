package com.dicoding.movietvcatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.movietvcatalogue.BuildConfig
import com.dicoding.movietvcatalogue.data.source.local.LocalDataSource
import com.dicoding.movietvcatalogue.data.source.remote.ApiResponse
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.data.source.remote.response.ResultsMovieItem
import com.dicoding.movietvcatalogue.data.source.remote.response.ResultsTvShowItem
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.utils.AppExecutors
import com.dicoding.movietvcatalogue.vo.Resource

class MovieTvRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieTvDataSource {


    private val basePosterUrl = BuildConfig.BASE_URLIMG
    private val _movieDetailData = MutableLiveData<MovieTvDetailEntity>()
    private val _tvShowDetailData = MutableLiveData<MovieTvDetailEntity>()


    override fun loadMovieApi(sort: String): LiveData<Resource<PagedList<MovieTVEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieTVEntity>, ArrayList<ResultsMovieItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieTVEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()
                return LivePagedListBuilder(localDataSource.getDataMovie(sort), config).build()
            }


            override fun shouldFetch(data: PagedList<MovieTVEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<ArrayList<ResultsMovieItem>>> =
                remoteDataSource.loadMovieApi()

            override fun saveCallResult(movies: ArrayList<ResultsMovieItem>) {
                val movieList = ArrayList<MovieTVEntity>()
                for (movie in movies) {
                    val date = movie.releaseDate.split("-").toTypedArray()
                    val movieItem = MovieTVEntity(
                        movie.id,
                        movie.title,
                        date[0],
                        basePosterUrl + movie.posterPath,
                        1,
                        false
                    )

                    movieList.add(movieItem)
                }
                localDataSource.insertMovieTv(movieList)
            }

        }.asLiveData()

    }

    override fun loadTvShowApi(sort: String): LiveData<Resource<PagedList<MovieTVEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieTVEntity>, ArrayList<ResultsTvShowItem>>(
                appExecutors
            ) {
            override fun loadFromDB(): LiveData<PagedList<MovieTVEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(5)
                    .setPageSize(5)
                    .build()

                return LivePagedListBuilder(localDataSource.getDataTV(sort), config).build()
            }


            override fun shouldFetch(data: PagedList<MovieTVEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<ArrayList<ResultsTvShowItem>>> =
                remoteDataSource.loadTvShowApi()

            override fun saveCallResult(tvShows: ArrayList<ResultsTvShowItem>) {
                val tvShowList = ArrayList<MovieTVEntity>()
                for (tvShow in tvShows) {
                    val date = tvShow.firstAirDate.split("-").toTypedArray()
                    val show = MovieTVEntity(
                        tvShow.id,
                        tvShow.name,
                        date[0],
                        basePosterUrl + tvShow.posterPath,
                        2,
                        false
                    )

                    tvShowList.add(show)
                }
                localDataSource.insertMovieTv(tvShowList)
            }

        }.asLiveData()
    }

    override fun loadDetailMovieApi(movieId: String): LiveData<MovieTvDetailEntity> {
        val movieDetailData: LiveData<MovieTvDetailEntity> = _movieDetailData

        remoteDataSource.loadMovieDetailApi(movieId).observeForever(Observer { movie ->
            val movieDetail = movie.body
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

        remoteDataSource.loadTvShowDetailApi(tvShowId).observeForever(Observer { shows ->
            val showsDetail = shows.body
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

    override fun getFavoriteMovie(): LiveData<List<MovieTVEntity>> =
        localDataSource.getFavoriteMovie()

    override fun getFavoriteTvShow(): LiveData<List<MovieTVEntity>> =
        localDataSource.getFavoriteTvShow()


    override fun favorited(id: String) =
        appExecutors.diskIO().execute { localDataSource.favorited(id) }

    override fun unfavorited(id: String) =
        appExecutors.diskIO().execute { localDataSource.unfavorited(id) }


}