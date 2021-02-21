package com.dicoding.movietvcatalogue.activity.main.tvshow

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.databinding.FragmentTvBinding
import com.dicoding.movietvcatalogue.activity.detail.DetailActivity
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.activity.main.ItemClickCallback
import com.dicoding.movietvcatalogue.vo.Status
import org.koin.androidx.viewmodel.ext.android.viewModel


class TvFragment : Fragment() {

    private lateinit var tvBinding: FragmentTvBinding
    private lateinit var tvAdapter: TvAdapter
    private val viewModel by viewModel<TvShowViewModel>()

    fun newInstance(): TvFragment {
        return TvFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tvBinding = FragmentTvBinding.inflate(layoutInflater, container, false)
        return tvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            tvAdapter = TvAdapter()


                //viewModel.fetchTvShow()
                viewModel.getTvShow().observe(viewLifecycleOwner, { tvShows ->
                    if (tvShows != null) {
                        when(tvShows.status){
                            Status.LOADING -> showLoading(true)
                            Status.SUCCESS -> {
                                showLoading(false)
                                tvAdapter.submitList(tvShows.data)
                                Log.d("tvData", tvShows.data.toString() )


                            }
                            Status.ERROR -> {
                                showLoading(false)
                                Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }


                    }
                })

            with(tvBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
                showLoading(false)

                tvAdapter.setOnItemClick(object : ItemClickCallback {
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
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            tvBinding.progressBar.visibility = View.VISIBLE
        } else {
            tvBinding.progressBar.visibility = View.GONE
        }
    }

    private fun showWarning(error: Boolean) {
        if (error) {
            tvBinding.rvTvShow.visibility = View.GONE
            tvBinding.warning.visibility = View.VISIBLE
        }
    }
}