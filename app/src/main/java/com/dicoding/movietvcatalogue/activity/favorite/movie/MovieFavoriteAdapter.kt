package com.dicoding.movietvcatalogue.activity.favorite.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.activity.ItemClickCallback
import com.dicoding.movietvcatalogue.databinding.ItemFavoriteMovieBinding
import com.dicoding.movietvcatalogue.databinding.ItemMoviesBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

class MovieFavoriteAdapter : RecyclerView.Adapter<MovieFavoriteAdapter.MovieViewHolder>() {

    private val listShow = ArrayList<MovieTVEntity>()

    private var onItemClickCallback: ItemClickCallback? = null

    fun setShow(shows: List<MovieTVEntity>?) {
        if (shows == null) return
        this.listShow.clear()
        this.listShow.addAll(shows)
    }

    inner class MovieViewHolder(private val binding: ItemFavoriteMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(show: MovieTVEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(show.poster)
                    .apply(RequestOptions().override(130, 144))
                    .into(ivPoster)

                tvTitle.text = show.title
                tvDate.text = show.date

                itemView.setOnClickListener { onItemClickCallback?.onItemClick(show) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = ItemFavoriteMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val show = listShow[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShow.size

    fun setOnItemClick(onItemClick: ItemClickCallback){
        this.onItemClickCallback = onItemClick
    }
}