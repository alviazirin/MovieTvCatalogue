package com.dicoding.movietvcatalogue.main.movie


import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel


    @Before
    fun setup(){
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {

        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(19,movies.size)
    }



    @Test
    fun getNullData(){
        try {
            val nullData = viewModel.getNull()

        } catch (e: NullPointerException){
            Assert.fail("Throw Null Exception")
        }
    }
}