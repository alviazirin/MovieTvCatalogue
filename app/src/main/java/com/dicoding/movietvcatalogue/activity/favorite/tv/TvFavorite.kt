package com.dicoding.movietvcatalogue.activity.favorite.tv

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.activity.detail.DetailActivity
import com.dicoding.movietvcatalogue.activity.ItemClickCallback
import com.dicoding.movietvcatalogue.databinding.FragmentTvFavoriteBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvFavorite : Fragment() {

    private var _fragmentTvFavoriteBinding: FragmentTvFavoriteBinding? = null
    private val binding get() = _fragmentTvFavoriteBinding

    private lateinit var adapter: TvFavoriteAdapter

    private val viewModel by viewModel<TvFavoriteViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _fragmentTvFavoriteBinding =
            FragmentTvFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            adapter = TvFavoriteAdapter()

            viewModel.getTvFavorite().observe(viewLifecycleOwner, { shows ->
                if (shows != null) {
                    adapter.setShow(shows)

                    with(binding?.rvTvShow) {
                        this?.layoutManager = LinearLayoutManager(context)
                        this?.setHasFixedSize(true)
                        this?.adapter = adapter

                        adapter.setOnItemClick(object : ItemClickCallback {
                            override fun onItemClick(data: MovieTVEntity) {
                                val intent = Intent(context, DetailActivity::class.java)
                                intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                                intent.putExtra(DetailActivity.TYPE, data.type)
                                intent.putExtra(DetailActivity.FAVORITE, data.favorite)
                                startActivity(intent)
                            }
                        })
                    }
                }
            })
        }
    }


}