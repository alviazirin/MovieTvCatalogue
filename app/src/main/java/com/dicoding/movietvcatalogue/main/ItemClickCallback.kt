package com.dicoding.movietvcatalogue.main

import com.dicoding.movietvcatalogue.entity.MovieTVEntity

interface ItemClickCallback {
    fun onItemClick(data: MovieTVEntity)
}