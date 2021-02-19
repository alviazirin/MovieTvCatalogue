package com.dicoding.movietvcatalogue.activity.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.databinding.FragmentMovieFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MovieFavorite : Fragment() {

    private lateinit var adapter: MovieFavoriteAdapter

    private var _fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding? = null
    private val binding get() = _fragmentMovieFavoriteBinding

    private val viewmodel by viewModel<MovieFavoriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){

            adapter = MovieFavoriteAdapter()

            viewmodel.getMovie().observe(viewLifecycleOwner, { movies ->
                if (movies !=null){
                    adapter.setShow(movies)

                    with(binding?.rvMovies){
                        this?.layoutManager = LinearLayoutManager(context)
                        this?.setHasFixedSize(true)
                        this?.adapter = adapter
                    }
                }
            })
        }
    }
}

