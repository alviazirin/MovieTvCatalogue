package com.dicoding.movietvcatalogue.activity

import com.dicoding.movietvcatalogue.entity.MovieTVEntity

interface ItemClickCallback {
    fun onItemClick(data: MovieTVEntity)
}