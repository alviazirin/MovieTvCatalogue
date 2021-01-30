package com.dicoding.movietvcatalogue.detail


import android.content.Intent
import android.content.Intent.EXTRA_TEXT
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.databinding.ActivityDetailActitvityBinding
import com.dicoding.movietvcatalogue.entity.MovieTvDetailEntity
import com.dicoding.movietvcatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var detailActitvityBinding: ActivityDetailActitvityBinding
    private lateinit var data: MovieTvDetailEntity
    private lateinit var dataAll: List<MovieTvDetailEntity>

    companion object{
        const val EXTRA_ID = "extra_id"
        const val TYPE = "type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActitvityBinding = ActivityDetailActitvityBinding.inflate(layoutInflater)
        setContentView(detailActitvityBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        val extras = intent.extras
        if (extras != null){
            val id = extras.getInt(EXTRA_ID)
            val type = extras.getInt(TYPE)
            if (type == 1){
                data = viewModel.getDetailMovie(id.toString())
            } else {
               data = viewModel.getDetailTvShow(id.toString())
            }
            fillDetail(data)
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
    }



}