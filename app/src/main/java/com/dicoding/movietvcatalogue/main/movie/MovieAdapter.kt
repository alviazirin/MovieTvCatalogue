package com.dicoding.movietvcatalogue.main.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.databinding.ItemMoviesBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.main.ItemClickCallback

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listShows = ArrayList<MovieTVEntity>()
    private var onItemClickCallback: ItemClickCallback? = null

    fun setOnItemClick(onItemClick: ItemClickCallback) {
        this.onItemClickCallback = onItemClick
    }


    fun setShow(shows: List<MovieTVEntity>?) {
        if (shows == null)
            return
        this.listShows.clear()
        this.listShows.addAll(shows)
    }

    inner class MovieViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(shows: MovieTVEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(shows.poster)
                    .apply(RequestOptions().override(130, 144))
                    .into(ivPoster)
                Log.d("adapter", shows.date)

                tvTitle.text = shows.title
                tvGenre.text = shows.date

                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClick(shows)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMoviesBinding =
            ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMoviesBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val show = listShows[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShows.size
}