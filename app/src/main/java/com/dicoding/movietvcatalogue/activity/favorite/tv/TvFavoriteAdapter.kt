package com.dicoding.movietvcatalogue.activity.favorite.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.activity.ItemClickCallback
import com.dicoding.movietvcatalogue.databinding.ItemFavoriteTvshowBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity

class TvFavoriteAdapter : RecyclerView.Adapter<TvFavoriteAdapter.ViewHolder>() {

    private val listShow = ArrayList<MovieTVEntity>()

    private var onItemClickCallback: ItemClickCallback? = null

    fun setShow(shows: List<MovieTVEntity>?) {
        if (shows == null) return
        this.listShow.clear()
        this.listShow.addAll(shows)
    }

    inner class ViewHolder(private val binding: ItemFavoriteTvshowBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            ItemFavoriteTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = listShow[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShow.size

    fun setOnItemClick(onItemClick: ItemClickCallback) {
        this.onItemClickCallback = onItemClick
    }
}