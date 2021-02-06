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

    private lateinit var detailActitvityBinding: ActivityDetailActitvityBinding
    private lateinit var data: MovieTvDetailEntity
    private lateinit var dataAll: List<MovieTvDetailEntity>
    val viewModel by viewModel<DetailViewModel>()
    companion object{
        const val EXTRA_ID = "extra_id"
        const val TYPE = "type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActitvityBinding = ActivityDetailActitvityBinding.inflate(layoutInflater)
        setContentView(detailActitvityBinding.root)

        /*val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]*/
        val extras = intent.extras
        if (extras != null){
            val id = extras.getInt(EXTRA_ID)
            val type = extras.getInt(TYPE)
            showLoading(true)
            if (type == 1){
                viewModel.fetchDetailMovie(id.toString())
                viewModel.getDetailMovie().observe(this,{ detailData ->
                    fillDetail(detailData)
                })
            } else {
                viewModel.fetchDetailTvShow(id.toString())
                viewModel.getDetailTvShow().observe(this, {detailData ->
                    fillDetail(detailData)
                })
            }

        }
        detailActitvityBinding.fabShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                    putExtra(EXTRA_TEXT, detailActitvityBinding.tvUrl.text)
                type = "text/plain"
            }
           val shareIntent = Intent.createChooser(sendIntent, "Share To")
            startActivity(shareIntent)
        }
    }

    private fun fillDetail(showData: MovieTvDetailEntity) {
        Glide.with(this)
            .load(showData.poster)
            .apply(RequestOptions().override(168,208))
            .into(detailActitvityBinding.ivPoster)

        detailActitvityBinding.tvTitle.text = showData.title
        detailActitvityBinding.tvYear.text = showData.year
        detailActitvityBinding.tvGenre.text = showData.genre
        detailActitvityBinding.tvCreatorDirector.text = showData.producer
        detailActitvityBinding.tvDescription.text = showData.overview
        detailActitvityBinding.tvUrl.text = showData.url
        showLoading(false)
    }

    private fun showLoading(state: Boolean){
        if (state){
            detailActitvityBinding.progressBar.visibility = View.VISIBLE
        } else {
            detailActitvityBinding.progressBar.visibility = View.GONE
        }
    }



}