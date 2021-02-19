package com.dicoding.movietvcatalogue.activity.main


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.activity.favorite.FavoriteActivity
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mn_favorite){
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}