package com.dicoding.movietvcatalogue.main.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setup(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val show = viewModel.getTvShow()
        assertNotNull(show)
        assertEquals(12,show.size)
    }
}