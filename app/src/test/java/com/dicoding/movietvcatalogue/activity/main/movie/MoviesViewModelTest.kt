package com.dicoding.movietvcatalogue.activity.main.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.roomModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.DataDummy
import com.dicoding.movietvcatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Assert
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
class MoviesViewModelTest : KoinTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        val baseApplication = BaseApplication()
        modules(listOf(roomModule, appModule, viewModelModule))
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieTVEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieTVEntity>


    @Test
    fun checkInjection() {

        val mock = declareMock<MovieTvRepository>()

        assertNotNull(get<MovieTvRepository>())

        assertNotNull(get<MoviesViewModel>())
    }

    @Test
    fun getMovie() {

        val mock = declareMock<MoviesViewModel>()
        val dummyMovie = DataDummy.generateDummyMovie()

        val dummyData = Resource.success(pagedList)
        `when`(dummyData.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<MovieTVEntity>>>()
        movies.value = dummyData


        `when`(mock.getMovie()).thenReturn(movies)
        mock.getMovie()
        val viewModel = mock.getMovie()
        assertNotNull(viewModel.value)
        assertEquals(5, viewModel.value?.data?.size)

        viewModel.observeForever(observer)
        verify(observer).onChanged(dummyData)
    }


    @Test
    fun getNullData() {
        try {
            val mock = declareMock<MoviesViewModel>()

            mock.getNull()

        } catch (e: NullPointerException) {
            Assert.fail("Throw Null Exception")
        }
    }
}