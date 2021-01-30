package com.dicoding.movietvcatalogue.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieTvDetailEntity(
    var id: Int?,
    var title: String?,
    var year: String?,
    var genre: String?,
    var producer: String?,
    var overview: String?,
    var url: String?,
    var poster: String?

) : Parcelable
