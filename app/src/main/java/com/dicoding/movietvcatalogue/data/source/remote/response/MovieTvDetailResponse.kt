package com.dicoding.movietvcatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieTvDetailResponse(
    var id: Int,
    var title: String,
    var date: String,
    var genre: String,
    var productionCompanies: String,
    var overview: String,
    var homepage: String,
    var poster: String
) : Parcelable
