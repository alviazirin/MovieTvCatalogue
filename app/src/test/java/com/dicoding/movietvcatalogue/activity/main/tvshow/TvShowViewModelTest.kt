package com.dicoding.movietvcatalogue.activity.main.tvshow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

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
    fun getTvShow() {
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