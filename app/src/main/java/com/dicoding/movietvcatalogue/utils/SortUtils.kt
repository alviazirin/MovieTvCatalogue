package com.dicoding.movietvcatalogue.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {
    const val AZ = "Az"
    const val ZA = "Za"
    const val NEWEST = "Newest"
    const val OLDEST = "Oldest"

    fun getSortedMovieQuery(filter: String): SimpleSQLiteQuery {
        val baseQuery = StringBuilder().append("SELECT * FROM movietventity WHERE type = 1")
        if (filter == AZ) {
            baseQuery.append(" ORDER BY title ASC")
        } else if (filter == ZA) {
            baseQuery.append(" ORDER BY title DESC")
        } else if (filter == NEWEST) {
            baseQuery.append(" ORDER BY date DESC")
        } else if (filter == OLDEST) {
            baseQuery.append(" ORDER BY date ASC")
        }

        return SimpleSQLiteQuery(baseQuery.toString())
    }

    fun getSortedTvShowQuery(filter: String): SimpleSQLiteQuery {
        val baseQuery = StringBuilder().append("SELECT * FROM movietventity WHERE type = 2")
        if (filter == AZ) {
            baseQuery.append(" ORDER BY title ASC")
        } else if (filter == ZA) {
            baseQuery.append(" ORDER BY title DESC")
        } else if (filter == NEWEST) {
            baseQuery.append(" ORDER BY date DESC")
        } else if (filter == OLDEST) {
            baseQuery.append(" ORDER BY date ASC")
        }

        return SimpleSQLiteQuery(baseQuery.toString())
    }
}