package com.dicoding.movietvcatalogue.activity.main.tvshow

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
import com.dicoding.movietvcatalogue.utils.SortUtils
import com.dicoding.movietvcatalogue.vo.Resource
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
class TvShowViewModelTest : KoinTest {

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

        assertNotNull(get<TvShowViewModel>())
    }

    @Test
    fun getTvShow() {
        val mock = declareMock<TvShowViewModel>()
        val dummyShow = DataDummy.generateDummyTvShow()

        val dummyData = Resource.success(pagedList)
        `when`(dummyData.data?.size).thenReturn(5)

        val tvShow = MutableLiveData<Resource<PagedList<MovieTVEntity>>>()
        tvShow.value = dummyData


        `when`(mock.getTvShow(SortUtils.AZ)).thenReturn(tvShow)
        mock.getTvShow(SortUtils.AZ)
        val viewModel = mock.getTvShow(SortUtils.AZ)
        assertNotNull(viewModel)
        assertEquals(5, viewModel.value?.data?.size)

        viewModel.observeForever(observer)
        verify(observer).onChanged(dummyData)
    }


}