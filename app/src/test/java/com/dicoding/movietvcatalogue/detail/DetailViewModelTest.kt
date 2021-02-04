package com.dicoding.movietvcatalogue.detail

import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
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

class DetailViewModelTest : KoinTest {

    private val dummyMovieId = 1
    private val dummyTvId = 20


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

            val mock = declareMock<MovieTvRepository>()

            assertNotNull(get<MovieTvRepository>())

            assertNotNull(get<DetailViewModel>())

    }

    @Test
    fun getDetailMovie(){
        val dataDetail = DataDummy.generateDetail("1")
        val mock = declareMock<DetailViewModel>()
        `when`(mock.getDetailMovie("1")).thenReturn(DataDummy.generateDetail("1"))
        val data = mock.getDetailMovie("1")
        assertNotNull(data)
        assertEquals(dummyMovieId, data.id)
        assertEquals(dataDetail.title, data.title)
        assertEquals(dataDetail.year, data.year)
        assertEquals(dataDetail.genre, data.genre)
        assertEquals(dataDetail.producer, data.producer)
        assertEquals(dataDetail.overview, data.overview)
        assertEquals(dataDetail.poster, data.poster)
        assertEquals(dataDetail.url, data.url)
    }

    @Test
    fun getDetailTvShow(){
        val dataDetail = DataDummy.generateDetail("20")
        val mock = declareMock<DetailViewModel>()
        `when`(mock.getDetailTvShow("20")).thenReturn(DataDummy.generateDetail("20"))
        val data = mock.getDetailTvShow("20")
        assertNotNull(data)
        assertEquals(dummyTvId, data.id)
        assertEquals(dataDetail.title, data.title)
        assertEquals(dataDetail.year, data.year)
        assertEquals(dataDetail.genre, data.genre)
        assertEquals(dataDetail.producer, data.producer)
        assertEquals(dataDetail.overview, data.overview)
        assertEquals(dataDetail.poster, data.poster)
        assertEquals(dataDetail.url, data.url)
    }


}