package com.dicoding.movietvcatalogue.activity.main.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.movietvcatalogue.databinding.ItemTvshowsBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.activity.main.ItemClickCallback

class TvAdapter : PagedListAdapter<MovieTVEntity, TvAdapter.TvShowViewHolder>(DIFF_CALBACK) {

    companion object{
        private val DIFF_CALBACK = object : DiffUtil.ItemCallback<MovieTVEntity>(){
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
                tvDate.text = tvShow.date

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