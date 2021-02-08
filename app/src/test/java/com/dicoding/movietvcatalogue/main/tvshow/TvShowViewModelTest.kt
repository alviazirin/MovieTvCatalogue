package com.dicoding.movietvcatalogue.main.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
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
class TvShowViewModelTest : KoinTest {

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
    private lateinit var observer: Observer<ArrayList<MovieTVEntity>>



    @Test
    fun checkInjection() {
        val mock = declareMock<MovieTvRepository>()

        assertNotNull(get<MovieTvRepository>())

        assertNotNull(get<TvShowViewModel>())
    }

    @Test
    fun getTvShow(){
        val mock = declareMock<TvShowViewModel>()
        val dummyShow = DataDummy.generateDummyTvShow()
        val tvShow = MutableLiveData<ArrayList<MovieTVEntity>>()
        tvShow.value = dummyShow


        `when`(mock.getTvShow()).thenReturn(tvShow)
        mock.fetchTvShow()
        val viewModel = mock.getTvShow()
        assertNotNull(viewModel)
        assertEquals(12, viewModel.value?.size)

        viewModel.observeForever(observer)
        verify(observer).onChanged(dummyShow)
    }


}