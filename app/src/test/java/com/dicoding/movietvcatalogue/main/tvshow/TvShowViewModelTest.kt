package com.dicoding.movietvcatalogue.main.tvshow

import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
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

class TvShowViewModelTest : KoinTest {

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
    fun checkInjection() {
        val mock = declareMock<MovieTvRepository>()

        assertNotNull(get<MovieTvRepository>())

        assertNotNull(get<TvShowViewModel>())
    }

    @Test
    fun getTvShow(){
        val mock = declareMock<TvShowViewModel>()
        `when`(mock.fetchTvShow()).thenReturn(DataDummy.generateDummyTvShow())
        val tvShow = mock.fetchTvShow()
        assertNotNull(tvShow)
        assertEquals(12, tvShow.size)
    }


}