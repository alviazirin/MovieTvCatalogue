package com.dicoding.movietvcatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieTvResponse(
    var id: Int,
    var title: String,
    var date: String,
    var poster: String
): Parcelable
