package com.dicoding.movietvcatalogue.data.source

import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class MovieTvRepositoryTest : KoinTest {

    private val movieResponse = DataDummy.generateRemoteSourceMovie()
    private val tvShowResponse = DataDummy.generateRemoteSourceTvShow()
    private val movieDetailResponse = DataDummy.generateRemoteSourceDetail("1")
    private val tvDetailResponse = DataDummy.generateRemoteSourceDetail("20")

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        val baseApplication = BaseApplication()
        modules(listOf(appModule, viewModelModule))
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Test
    fun checkInjection(){
        val mock = declareMock<RemoteDataSource>()

        assertNotNull(get<RemoteDataSource>())

        assertNotNull(get<MovieTvRepository>())
    }

    @Test
    fun loadMovie() {
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadMovie()).thenReturn(movieResponse)
        val loadMovie = mock.loadMovie()
        assertNotNull(loadMovie)
        assertEquals(7,loadMovie.size)
    }

    @Test
    fun loadTvShow() {
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadTvShow()).thenReturn(tvShowResponse)
        val loadTvShow = mock.loadTvShow()
        assertNotNull(loadTvShow)
        assertEquals(7, loadTvShow.size)
    }

    @Test
    fun loadDetailMovie() {
        val dataDetail = DataDummy.generateDetail("1")
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadDetailMovie("1")).thenReturn(movieDetailResponse)
        val loadDetail = mock.loadDetailMovie("1")
        assertNotNull(loadDetail)
        assertEquals(dataDetail.id,loadDetail.id)
        assertEquals(dataDetail.title,loadDetail.title)
        assertEquals(dataDetail.year,loadDetail.date)
        assertEquals(dataDetail.genre,loadDetail.genre)
        assertEquals(dataDetail.producer,loadDetail.productionCompanies)
        assertEquals(dataDetail.overview,loadDetail.overview)
        assertEquals(dataDetail.url,loadDetail.homepage)
        assertEquals(dataDetail.poster,loadDetail.poster)
    }

    @Test
    fun loadDetailTvShow() {
        val dataDetail = DataDummy.generateDetail("20")
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadDetailTvShow("20")).thenReturn(tvDetailResponse)
        val loadDetail = mock.loadDetailTvShow("20")
        assertNotNull(loadDetail)
        assertEquals(dataDetail.id,loadDetail.id)
        assertEquals(dataDetail.title,loadDetail.title)
        assertEquals(dataDetail.year,loadDetail.date)
        assertEquals(dataDetail.genre,loadDetail.genre)
        assertEquals(dataDetail.producer,loadDetail.productionCompanies)
        assertEquals(dataDetail.overview,loadDetail.overview)
        assertEquals(dataDetail.url,loadDetail.homepage)
        assertEquals(dataDetail.poster,loadDetail.poster)
    }
}