package com.dicoding.movietvcatalogue.activity.detail


import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.databinding.ActivityDetailActitvityBinding
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {


    private var _detailActivityBinding: ActivityDetailActitvityBinding? = null
    private val binding get() = _detailActivityBinding
    private val viewModel by viewModel<DetailViewModel>()

    companion object {
        const val EXTRA_ID = "extra_id"
        const val TYPE = "type"
        const val FAVORITE = "favorite"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _detailActivityBinding = ActivityDetailActitvityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val extras = intent.extras
        if (extras != null) {
            val id = extras.getInt(EXTRA_ID)
            val type = extras.getInt(TYPE)
            val fav = extras.getBoolean(FAVORITE)
            showLoading(true)
            if (type == 1) {
                viewModel.fetchDetailMovie(id.toString())
                viewModel.getDetailMovie().observe(this, { detailData ->
                    fillDetail(detailData)
                    stateFavorite(fav)
                })
            } else {
                viewModel.fetchDetailTvShow(id.toString())
                viewModel.getDetailTvShow().observe(this, { detailData ->
                    fillDetail(detailData)
                    stateFavorite(fav)
                })
            }

            binding?.fabFav?.setOnClickListener {

                if (fav) {
                    viewModel.unfavorited(id.toString())
                    stateFavorite(!fav)
                } else {
                    viewModel.favorite(id.toString())
                    stateFavorite(!fav)
                }
            }
        }
        binding?.fabShare?.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(EXTRA_TEXT, binding?.tvUrl?.text)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, "Share To")
            startActivity(shareIntent)
        }

    }

    private fun fillDetail(showData: MovieTvDetailEntity) {
        Glide.with(this)
            .load(showData.poster)
            .apply(RequestOptions().override(168, 208))
            .into(binding?.ivPoster!!)

        binding?.tvTitle?.text = showData.title
        binding?.tvYear?.text = showData.year
        binding?.tvGenre?.text = showData.genre
        binding?.tvCreatorDirector?.text = showData.producer
        binding?.tvDescription?.text = showData.overview
        binding?.tvUrl?.text = showData.url
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding?.progressBar?.visibility = View.VISIBLE
        } else {
            binding?.progressBar?.visibility = View.GONE
        }
    }

    private fun stateFavorite(state: Boolean) {
        if (state) {
            binding?.fabFav?.setImageResource(R.drawable.ic_favorite)
        } else {
            binding?.fabFav?.setImageResource(R.drawable.ic_unfavorite)
        }
    }


}