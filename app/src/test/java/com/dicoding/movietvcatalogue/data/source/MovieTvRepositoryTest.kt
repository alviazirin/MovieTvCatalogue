package com.dicoding.movietvcatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.ResultsMovieItem
import com.dicoding.movietvcatalogue.data.source.remote.response.ResultsTvShowItem
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowDetailResponse
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieTvRepositoryTest : KoinTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        val baseApplication = BaseApplication()
        modules(listOf(appModule, viewModelModule))
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Mock
    private lateinit var observerMovie: Observer<ArrayList<ResultsMovieItem>>

    @Mock
    private lateinit var observerTvshow: Observer<ArrayList<ResultsTvShowItem>>

    @Mock
    private lateinit var observerDetailMovie: Observer<MovieDetailResponse>

    @Mock
    private lateinit var observerDetailTvShow: Observer<TvShowDetailResponse>

    @Test
    fun checkInjection() {
        val mock = declareMock<RemoteDataSource>()

        assertNotNull(get<RemoteDataSource>())

        assertNotNull(get<MovieTvRepository>())
    }

    @Test
    fun loadMovie() {
        val dataDummy = DataDummy.generateMovieApi()
        val movieResponse = MutableLiveData<ArrayList<ResultsMovieItem>>()
        movieResponse.value = dataDummy
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadMovieApi()).thenReturn(movieResponse)
        val loadMovie = mock.loadMovieApi()
        assertNotNull(loadMovie)
        assertEquals(7, loadMovie.value?.size)

        loadMovie.observeForever(observerMovie)
        verify(observerMovie).onChanged(dataDummy)
    }

    @Test
    fun loadTvShow() {
        val dataDummy = DataDummy.generateTvShowApi()
        val tvShowResponse = MutableLiveData<ArrayList<ResultsTvShowItem>>()
        tvShowResponse.value = dataDummy
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadTvShowApi()).thenReturn(tvShowResponse)
        val loadTvShow = mock.loadTvShowApi()
        assertNotNull(loadTvShow)
        assertEquals(7, loadTvShow.value?.size)

        loadTvShow.observeForever(observerTvshow)
        verify(observerTvshow).onChanged(dataDummy)
    }

    @Test
    fun loadDetailMovie() {
        val dataDummyDetail = DataDummy.generateMovieDetailApi("1")
        val dataDetail = MutableLiveData<MovieDetailResponse>()
        dataDetail.value = dataDummyDetail
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadMovieDetailApi("1")).thenReturn(dataDetail)
        val loadDetail = mock.loadMovieDetailApi("1")
        val dataExpected = dataDetail.value
        val dataActual = loadDetail.value
        assertNotNull(loadDetail)
        assertEquals(dataExpected?.id, dataActual?.id)
        assertEquals(dataExpected?.title, dataActual?.title)
        assertEquals(dataExpected?.releaseDate, dataActual?.releaseDate)
        assertEquals(dataExpected?.genres, dataActual?.genres)
        assertEquals(dataExpected?.productionCompanies, dataActual?.productionCompanies)
        assertEquals(dataExpected?.overview, dataActual?.overview)
        assertEquals(dataExpected?.homepage, dataActual?.homepage)
        assertEquals(dataExpected?.posterPath, dataActual?.posterPath)

        loadDetail.observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(dataDummyDetail)
    }

    @Test
    fun loadDetailTvShow() {
        val dataDummyDetail = DataDummy.generateTvDetailApi("20")
        val dataDetail = MutableLiveData<TvShowDetailResponse>()
        dataDetail.value = dataDummyDetail
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadTvShowDetailApi("20")).thenReturn(dataDetail)
        val loadDetail = mock.loadTvShowDetailApi("20")
        assertNotNull(loadDetail)
        val dataExpected = dataDetail.value
        val dataActual = loadDetail.value
        assertEquals(dataExpected?.id, dataActual?.id)
        assertEquals(dataExpected?.name, dataActual?.name)
        assertEquals(dataExpected?.firstAirDate, dataActual?.firstAirDate)
        assertEquals(dataExpected?.genres, dataActual?.genres)
        assertEquals(dataExpected?.productionCompanies, dataActual?.productionCompanies)
        assertEquals(dataExpected?.overview, dataActual?.overview)
        assertEquals(dataExpected?.homepage, dataActual?.homepage)
        assertEquals(dataExpected?.posterPath, dataActual?.posterPath)

        loadDetail.observeForever(observerDetailTvShow)
        verify(observerDetailTvShow).onChanged(dataDummyDetail)
    }


}