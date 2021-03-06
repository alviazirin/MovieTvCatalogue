package com.dicoding.movietvcatalogue.activity.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.activity.favorite.movie.MovieFavorite
import com.dicoding.movietvcatalogue.activity.favorite.tv.TvFavorite

class SectionPagerFavoriteAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TITLES = intArrayOf(R.string.movie_fav, R.string.tv_fav)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFavorite()
            1 -> fragment = TvFavorite()

        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TITLES[position])

}