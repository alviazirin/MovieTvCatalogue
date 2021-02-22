package com.dicoding.movietvcatalogue.activity.favorite.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.activity.favorite.movie.MovieFavoriteViewModel
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.roomModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.get
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvFavoriteViewModelTest : KoinTest {

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
    private lateinit var observer: Observer<List<MovieTVEntity>>

    @Test
    fun checkInjection() {
        val mock = declareMock<MovieTvRepository>()

        assertNotNull(get<MovieTvRepository>())

        assertNotNull(get<MovieFavoriteViewModel>())
    }

    @Test
    fun getTvFavorite() {
        val mock = declareMock<TvFavoriteViewModel>()
        val dummy = DataDummy.generateDummyTvShow()
        val dataDummy = MutableLiveData<List<MovieTVEntity>>()
        dataDummy.value = dummy
        Mockito.`when`(mock.getTvFavorite()).thenReturn(dataDummy)
        val viewModel = mock.getTvFavorite()

        assertNotNull(viewModel.value)
        assertEquals(12, viewModel.value?.size)

        viewModel.observeForever(observer)
        verify(observer).onChanged(dummy)
    }
}