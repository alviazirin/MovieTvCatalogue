package com.dicoding.movietvcatalogue.activity.main.movie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.R
import com.dicoding.movietvcatalogue.activity.detail.DetailActivity
import com.dicoding.movietvcatalogue.activity.favorite.FavoriteActivity
import com.dicoding.movietvcatalogue.activity.ItemClickCallback
import com.dicoding.movietvcatalogue.databinding.FragmentMoviesBinding
import com.dicoding.movietvcatalogue.entity.MovieTVEntity
import com.dicoding.movietvcatalogue.utils.SortUtils
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

            setHasOptionsMenu(true)

            moviesAdapter = MovieAdapter()

            viewModel.getMovie(SortUtils.AZ).observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCESS -> {
                            showLoading(false)
                            moviesAdapter.submitList(movies.data)
                            Log.d("movieData", movies.data.toString())
                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(context, "Terdapat Kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

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
                        intent.putExtra(DetailActivity.FAVORITE, data.favorite)
                        startActivity(intent)
                    }
                })
            }
        }
        moviesBinding.testCon.setOnClickListener { showWarning(true) }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()

        inflater.inflate(R.menu.menu_main, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var sort = ""
        when (item.itemId) {
            R.id.mn_favorite -> {
                val intent = Intent(context, FavoriteActivity::class.java)
                startActivity(intent)
            }
            R.id.st_az -> {
                sort = SortUtils.AZ
            }
            R.id.st_za -> {
                sort = SortUtils.ZA
            }
            R.id.st_ne -> {
                sort = SortUtils.NEWEST
            }
            R.id.st_ol -> {
                sort = SortUtils.OLDEST
            }
        }

        moviesAdapter = MovieAdapter()

        viewModel.getMovie(sort).observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> showLoading(true)
                    Status.SUCCESS -> {
                        showLoading(false)
                        moviesAdapter.submitList(movies.data)
                        Log.d("movieData", movies.data.toString())
                    }
                    Status.ERROR -> {
                        showLoading(false)
                        Toast.makeText(context, "Terdapat Kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

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
                    intent.putExtra(DetailActivity.FAVORITE, data.favorite)
                    startActivity(intent)
                }
            })
        }
        return super.onOptionsItemSelected(item)
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