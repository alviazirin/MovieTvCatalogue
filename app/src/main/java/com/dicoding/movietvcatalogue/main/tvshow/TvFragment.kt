package com.dicoding.movietvcatalogue.main.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.databinding.FragmentTvBinding
import com.dicoding.movietvcatalogue.viewmodel.ViewModelFactory
import java.lang.NullPointerException


class TvFragment : Fragment() {

    private lateinit var tvBinding: FragmentTvBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return tvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            try {
                showLoading(true)
                val tvShow = viewModel.getTvShow()
                val tvAdapter = TvAdapter()
                tvAdapter.setShow(tvShow)

                with(tvBinding.rvTvShow){
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvAdapter
                }
                showLoading(false)
            } catch (e: NullPointerException){
                showWarning(true)
            }
         }
    }

    private fun showLoading(state: Boolean){
        if (state){
            tvBinding.progressBar.visibility = View.VISIBLE
        } else {
            tvBinding.progressBar.visibility = View.GONE
        }
    }
    private fun showWarning(error: Boolean){
        if (error){
            tvBinding.rvTvShow.visibility = View.GONE
            tvBinding.warning.visibility = View.VISIBLE
        }
    }
}