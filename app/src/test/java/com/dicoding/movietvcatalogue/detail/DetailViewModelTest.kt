package com.dicoding.movietvcatalogue.detail

import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private lateinit var showDetails: MovieTvDetailEntity
    private val dummyId = 1
    private val typeMovie = 1
    private val typeTvShow = 2


    @Before
    fun setup(){
        viewModel = DetailViewModel()
    }

    @Test
    fun getDetailMovie(){
        val data = viewModel.getDetail(typeMovie,dummyId)
        assertNotNull(data)
        assertEquals(dummyId, data.id)
    }

    @Test
    fun getDetailTvShow(){
        val data = viewModel.getDetail(typeTvShow,dummyId)
        assertNotNull(data)
        assertEquals(dummyId, data.id)
    }


}