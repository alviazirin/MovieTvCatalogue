package com.dicoding.movietvcatalogue.activity.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
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
import org.mockito.Mockito.times


import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest : KoinTest {

    private val dummyMovieId = 1
    private val dummyTvId = 20

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
    private lateinit var observer: Observer<MovieTvDetailEntity>

    @Test
    fun checkInjection() {

        val mock = declareMock<MovieTvRepository>()

        assertNotNull(get<MovieTvRepository>())

        assertNotNull(get<DetailViewModel>())

    }

    @Test
    fun getDetailMovie() {
        val dataDummyDetail = DataDummy.generateDetail("1")
        val dataDetail = MutableLiveData<MovieTvDetailEntity>()
        dataDetail.value = dataDummyDetail

        val mock = declareMock<DetailViewModel>()
        `when`(mock.getDetailMovie()).thenReturn(dataDetail)
        mock.fetchDetailMovie("1")

        val data = mock.getDetailMovie()
        assertNotNull(data)

        val dataExpected = dataDetail.value
        val dataActual = data.value
        assertEquals(dummyMovieId, dataActual?.id)
        assertEquals(dataExpected?.title, dataActual?.title)
        assertEquals(dataExpected?.year, dataActual?.year)
        assertEquals(dataExpected?.genre, dataActual?.genre)
        assertEquals(dataExpected?.producer, dataActual?.producer)
        assertEquals(dataExpected?.overview, dataActual?.overview)
        assertEquals(dataExpected?.poster, dataActual?.poster)
        assertEquals(dataExpected?.url, dataActual?.url)

        data.observeForever(observer)
        verify(observer).onChanged(dataDummyDetail)
    }

    @Test
    fun getDetailTvShow() {
        val dataDummyDetail = DataDummy.generateDetail("20")
        val dataDetail = MutableLiveData<MovieTvDetailEntity>()
        dataDetail.value = dataDummyDetail

        val mock = declareMock<DetailViewModel>()
        `when`(mock.getDetailTvShow()).thenReturn(dataDetail)
        mock.fetchDetailMovie("20")

        val data = mock.getDetailTvShow()
        assertNotNull(data)

        val dataExpected = dataDetail.value
        val dataActual = data.value
        assertEquals(dummyTvId, dataActual?.id)
        assertEquals(dataExpected?.title, dataActual?.title)
        assertEquals(dataExpected?.year, dataActual?.year)
        assertEquals(dataExpected?.genre, dataActual?.genre)
        assertEquals(dataExpected?.producer, dataActual?.producer)
        assertEquals(dataExpected?.overview, dataActual?.overview)
        assertEquals(dataExpected?.poster, dataActual?.poster)
        assertEquals(dataExpected?.url, dataActual?.url)

        data.observeForever(observer)
        verify(observer).onChanged(dataDummyDetail)
    }

    @Test
    fun testFavoriteMovie(){
        val mock = declareMock<DetailViewModel>()
        mock.favorite("1")
        verify(mock, times(1)).favorite("1")
    }

    @Test
    fun testUnfavoriteMovie(){
        val mock = declareMock<DetailViewModel>()
        mock.unfavorited("1")
        verify(mock, times(1)).unfavorited("1")
    }


}