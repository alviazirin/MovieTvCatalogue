package com.dicoding.movietvcatalogue.detail


import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.databinding.ActivityDetailActitvityBinding
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var detailActivityBinding: ActivityDetailActitvityBinding
    private val viewModel by viewModel<DetailViewModel>()

    companion object {
        const val EXTRA_ID = "extra_id"
        const val TYPE = "type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityBinding = ActivityDetailActitvityBinding.inflate(layoutInflater)
        setContentView(detailActivityBinding.root)


        val extras = intent.extras
        if (extras != null) {
            val id = extras.getInt(EXTRA_ID)
            val type = extras.getInt(TYPE)
            showLoading(true)
            if (type == 1) {
                viewModel.fetchDetailMovie(id.toString())
                viewModel.getDetailMovie().observe(this, { detailData ->
                    fillDetail(detailData)
                })
            } else {
                viewModel.fetchDetailTvShow(id.toString())
                viewModel.getDetailTvShow().observe(this, { detailData ->
                    fillDetail(detailData)
                })
            }

        }
        detailActivityBinding.fabShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(EXTRA_TEXT, detailActivityBinding.tvUrl.text)
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
            .into(detailActivityBinding.ivPoster)

        detailActivityBinding.tvTitle.text = showData.title
        detailActivityBinding.tvYear.text = showData.year
        detailActivityBinding.tvGenre.text = showData.genre
        detailActivityBinding.tvCreatorDirector.text = showData.producer
        detailActivityBinding.tvDescription.text = showData.overview
        detailActivityBinding.tvUrl.text = showData.url
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            detailActivityBinding.progressBar.visibility = View.VISIBLE
        } else {
            detailActivityBinding.progressBar.visibility = View.GONE
        }
    }


}