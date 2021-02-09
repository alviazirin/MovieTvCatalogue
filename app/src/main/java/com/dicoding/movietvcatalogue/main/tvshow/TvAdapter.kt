package com.dicoding.movietvcatalogue.main.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.databinding.ItemTvshowsBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.main.ItemClickCallback

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvShowViewHolder>() {

    private val listTvShow = ArrayList<MovieTVEntity>()
    private var onItemClickCallback: ItemClickCallback? = null

    fun setOnItemClick(onItemClick: ItemClickCallback) {
        this.onItemClickCallback = onItemClick
    }

    fun setShow(tvShow: List<MovieTVEntity>?) {
        if (tvShow == null)
            return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShow)
    }

    inner class TvShowViewHolder(private val binding: ItemTvshowsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: MovieTVEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .apply(RequestOptions().override(130, 144))
                    .into(ivPoster)

                tvTitle.text = tvShow.title
                tvGenre.text = tvShow.date

                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClick(tvShow)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemTvshowsBinding =
            ItemTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemTvshowsBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size
}