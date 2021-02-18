package com.dicoding.movietvcatalogue.activity.main

import com.dicoding.movietvcatalogue.entity.MovieTVEntity

interface ItemClickCallback {
    fun onItemClick(data: MovieTVEntity)
}