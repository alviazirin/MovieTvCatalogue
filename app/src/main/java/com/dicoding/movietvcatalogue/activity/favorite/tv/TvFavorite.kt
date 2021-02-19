package com.dicoding.movietvcatalogue.activity.favorite.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.databinding.FragmentTvFavoriteBinding
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

        _fragmentTvFavoriteBinding = FragmentTvFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            adapter = TvFavoriteAdapter()

            viewModel.getTvFavorite().observe(viewLifecycleOwner, {shows ->
                if (shows != null){
                    adapter.setShow(shows)

                    with(binding?.rvTvShow){
                        this?.layoutManager = LinearLayoutManager(context)
                        this?.setHasFixedSize(true)
                        this?.adapter = adapter
                    }
                }
            })
        }
    }


}