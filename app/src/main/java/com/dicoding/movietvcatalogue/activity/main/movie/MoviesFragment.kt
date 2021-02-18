package com.dicoding.movietvcatalogue.activity.main.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.databinding.FragmentMoviesBinding
import com.dicoding.movietvcatalogue.activity.detail.DetailActivity
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.activity.main.ItemClickCallback
import com.dicoding.movietvcatalogue.vo.Status
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesFragment : Fragment() {

    private lateinit var moviesBinding: FragmentMoviesBinding
    private lateinit var moviesAdapter: MovieAdapter

    private val viewModel by viewModel<MoviesViewModel>()

    fun newInstance(): MoviesFragment {
        return MoviesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return moviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            moviesAdapter = MovieAdapter()
            try {
                showLoading(true)
                //viewModel.fetchMovie()
                viewModel.getMovie().observe(viewLifecycleOwner) { movies ->
                    if (movies != null) {
                        when(movies.status){
                            Status.LOADING -> showLoading(true)
                            Status.SUCCESS -> {
                                moviesAdapter.setShow(movies.data)
                                moviesAdapter.notifyDataSetChanged()

                                with(moviesBinding.rvMovies) {
                                    layoutManager = LinearLayoutManager(context)
                                    setHasFixedSize(true)
                                    adapter = moviesAdapter
                                    showLoading(false)

                                    moviesAdapter.setOnItemClick(object : ItemClickCallback {
                                        override fun onItemClick(data: MovieTVEntity) {
                                            val intent = Intent(context, DetailActivity::class.java)
                                            intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                                            intent.putExtra(DetailActivity.TYPE, data.type)
                                            startActivity(intent)
                                        }

                                    })
                                }
                            }
                            Status.ERROR -> {
                                showLoading(false)
                                Toast.makeText(context, "Terdapat Kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }



                    }
                }
            } catch (e: NullPointerException) {
                showWarning(true)
            }

        }
        moviesBinding.testCon.setOnClickListener { showWarning(true) }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            moviesBinding.progressBar.visibility = View.VISIBLE
        } else {
            moviesBinding.progressBar.visibility = View.GONE
        }
    }

    private fun showWarning(error: Boolean) {
        if (error) {
            moviesBinding.rvMovies.visibility = View.GONE
            moviesBinding.warning.visibility = View.VISIBLE
        }
    }


}