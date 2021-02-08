package com.dicoding.movietvcatalogue.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.main.movie.MoviesFragment
import com.dicoding.movietvcatalogue.main.tvshow.TvFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MoviesFragment().newInstance()
            1 -> fragment = TvFragment().newInstance()
        }
        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TITLES[position])

}