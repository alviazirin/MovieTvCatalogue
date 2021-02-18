package com.dicoding.movietvcatalogue.activity.main.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movietvcatalogue.data.source.MovieTvRepository
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.DataDummy

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest : KoinTest {

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

        assertNotNull(get<MoviesViewModel>())
    }

    @Test
    fun getMovie() {
        val mock = declareMock<MoviesViewModel>()
        val dummyMovie = DataDummy.generateDummyMovie()
        val movies = MutableLiveData<ArrayList<MovieTVEntity>>()
        movies.value = dummyMovie

        `when`(mock.getMovie()).thenReturn(movies)
        mock.fetchMovie()
        val viewModel = mock.getMovie()
        assertNotNull(viewModel.value)
        assertEquals(19, viewModel.value?.size)

        viewModel.observeForever(observer)
        verify(observer).onChanged(dummyMovie)
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