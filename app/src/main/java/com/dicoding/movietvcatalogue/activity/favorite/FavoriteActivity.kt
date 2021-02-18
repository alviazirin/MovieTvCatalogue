package com.dicoding.movietvcatalogue.activity.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private var _activityFavoriteBinding: ActivityFavoriteBinding? = null
    private val binding get() = _activityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sectionPagerFavoriteAdapter = SectionPagerFavoriteAdapter(this, supportFragmentManager)
        binding?.viewPager?.adapter = sectionPagerFavoriteAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)
    }
}