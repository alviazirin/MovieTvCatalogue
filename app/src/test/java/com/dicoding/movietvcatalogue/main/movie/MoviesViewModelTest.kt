package com.dicoding.movietvcatalogue.main.movie


import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.utils.DataDummy
import org.junit.Assert
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


class MoviesViewModelTest : KoinTest {



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

        assertNotNull(get<MoviesViewModel>())
    }

    @Test
    fun getMovie(){
        val mock = declareMock<MoviesViewModel>()

        `when`(mock.fetchMovie()).thenReturn(DataDummy.generateDummyMovie())
        val viewModel = mock.fetchMovie()
        assertNotNull(viewModel)
        assertEquals(19, viewModel.size)

    }


    @Test
    fun getNullData(){
        try {
            val mock = declareMock<MoviesViewModel>()
            val viewModel = mock.getNull()

        } catch (e: NullPointerException){
            Assert.fail("Throw Null Exception")
        }
    }
}