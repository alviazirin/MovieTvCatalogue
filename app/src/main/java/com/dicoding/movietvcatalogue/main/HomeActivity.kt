package com.dicoding.movietvcatalogue.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.movietvcatalogue.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        mainBinding.viewPager.adapter = sectionPagerAdapter
        mainBinding.tabs.setupWithViewPager(mainBinding.viewPager)
    }
}