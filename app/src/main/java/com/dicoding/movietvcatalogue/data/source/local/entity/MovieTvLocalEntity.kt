package com.dicoding.movietvcatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class MovieTvLocalEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idLocal")
    var idLocal: Int = 0,

    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "poster")
    var poster: String? = null
) : Parcelable
