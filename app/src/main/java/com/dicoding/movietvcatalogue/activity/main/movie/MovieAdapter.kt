package com.dicoding.movietvcatalogue.activity.main.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.activity.main.ItemClickCallback
import com.dicoding.movietvcatalogue.databinding.ItemMoviesBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

class MovieAdapter : PagedListAdapter<MovieTVEntity, MovieAdapter.MovieViewHolder>(DIFF_CALBACK) {

    companion object {
        private val DIFF_CALBACK = object : DiffUtil.ItemCallback<MovieTVEntity>() {
            override fun areItemsTheSame(oldItem: MovieTVEntity, newItem: MovieTVEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MovieTVEntity,
                newItem: MovieTVEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

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
                tvDate.text = shows.date

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
        val show = getItem(position)
        if (show != null){
        holder.bind(show)
        }
    }

    /*override fun getItemCount(): Int = listShows.size*/
}