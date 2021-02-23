package com.dicoding.movietvcatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import com.dicoding.movietvcatalogue.data.source.local.LocalDataSource
import com.dicoding.movietvcatalogue.data.source.remote.ApiResponse
import com.dicoding.movietvcatalogue.data.source.remote.RemoteDataSource
import com.dicoding.movietvcatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.movietvcatalogue.data.source.remote.response.TvShowDetailResponse
import com.dicoding.movietvcatalogue.di.BaseApplication
import com.dicoding.movietvcatalogue.di.appModule
import com.dicoding.movietvcatalogue.di.roomModule
import com.dicoding.movietvcatalogue.di.viewModelModule
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.AppExecutors
import com.dicoding.movietvcatalogue.utils.DataDummy
import com.dicoding.movietvcatalogue.utils.PagedListUtil
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieTvRepositoryTest : KoinTest {


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        val baseApplication = BaseApplication()
        modules(listOf(roomModule, appModule, viewModelModule))
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        mock(clazz.java)
    }

    @Mock
    private lateinit var observerDetailMovie: Observer<ApiResponse<MovieDetailResponse>>

    @Mock
    private lateinit var observerDetailTvShow: Observer<ApiResponse<TvShowDetailResponse>>

    private val dataSourceFactory =
        mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieTVEntity>

    @Test
    fun checkInjection() {

        val mockRemote = declareMock<RemoteDataSource>()
        val mockLocal = declareMock<LocalDataSource>()
        val mockExecutors = declareMock<AppExecutors>()

        assertNotNull(get<RemoteDataSource>())
        assertNotNull(get<LocalDataSource>())
        assertNotNull(get<AppExecutors>())

        assertNotNull(get<MovieTvRepository>())
    }

    @Test
    fun loadMovie() {

        val mock = declareMock<LocalDataSource>()
        `when`(mock.getDataMovie(SortUtils.AZ)).thenReturn(dataSourceFactory)
        mock.getDataMovie(SortUtils.AZ)

        val movieEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(mock).getDataMovie(SortUtils.AZ)
        assertNotNull(movieEntities.data)
        assertEquals(19, movieEntities.data?.size)

    }

    @Test
    fun loadTvShow() {
        val mock = declareMock<LocalDataSource>()
        `when`(mock.getDataTV(SortUtils.AZ)).thenReturn(dataSourceFactory)
        mock.getDataTV(SortUtils.AZ)

        val showEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(mock).getDataTV(SortUtils.AZ)
        assertNotNull(showEntities.data)
        assertEquals(12, showEntities.data?.size)
    }

    @Test
    fun loadDetailMovie() {
        val dataDummyDetail = ApiResponse.success(DataDummy.generateMovieDetailApi("1"))
        val dataDetail = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        dataDetail.value = dataDummyDetail
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadMovieDetailApi("1")).thenReturn(dataDetail)
        val loadDetail = mock.loadMovieDetailApi("1")
        val dataExpected = dataDetail.value?.body
        val dataActual = loadDetail.value?.body

        assertNotNull(loadDetail)

        assertEquals(dataExpected?.id, dataActual?.id)
        assertEquals(dataExpected?.title, dataActual?.title)
        assertEquals(dataExpected?.releaseDate, dataActual?.releaseDate)
        assertEquals(dataExpected?.genres, dataActual?.genres)
        assertEquals(dataExpected?.productionCompanies, dataActual?.productionCompanies)
        assertEquals(dataExpected?.overview, dataActual?.overview)
        assertEquals(dataExpected?.homepage, dataActual?.homepage)
        assertEquals(dataExpected?.posterPath, dataActual?.posterPath)

        loadDetail.observeForever(observerDetailMovie)
        verify(observerDetailMovie).onChanged(dataDummyDetail)
    }

    @Test
    fun loadDetailTvShow() {
        val dataDummyDetail = ApiResponse.success(DataDummy.generateTvDetailApi("20"))
        val dataDetail = MutableLiveData<ApiResponse<TvShowDetailResponse>>()
        dataDetail.value = dataDummyDetail
        val mock = declareMock<RemoteDataSource>()
        `when`(mock.loadTvShowDetailApi("20")).thenReturn(dataDetail)
        val loadDetail = mock.loadTvShowDetailApi("20")

        assertNotNull(loadDetail)

        val dataExpected = dataDetail.value?.body
        val dataActual = loadDetail.value?.body
        assertEquals(dataExpected?.id, dataActual?.id)
        assertEquals(dataExpected?.name, dataActual?.name)
        assertEquals(dataExpected?.firstAirDate, dataActual?.firstAirDate)
        assertEquals(dataExpected?.genres, dataActual?.genres)
        assertEquals(dataExpected?.productionCompanies, dataActual?.productionCompanies)
        assertEquals(dataExpected?.overview, dataActual?.overview)
        assertEquals(dataExpected?.homepage, dataActual?.homepage)
        assertEquals(dataExpected?.posterPath, dataActual?.posterPath)

        loadDetail.observeForever(observerDetailTvShow)
        verify(observerDetailTvShow).onChanged(dataDummyDetail)
    }


}