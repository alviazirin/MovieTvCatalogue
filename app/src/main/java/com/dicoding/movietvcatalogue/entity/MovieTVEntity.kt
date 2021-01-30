package com.dicoding.movietvcatalogue.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieTVEntity(
    var id: Int,
    var title: String,
    var date: String,
    var poster: String
) : Parcelable
