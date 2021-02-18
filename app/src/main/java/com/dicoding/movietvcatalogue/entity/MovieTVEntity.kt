package com.dicoding.movietvcatalogue.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "movietventity")
@Parcelize
data class MovieTVEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "type")
    var type: Int,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean
) : Parcelable
