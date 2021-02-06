package com.dicoding.movietvcatalogue.main.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.movietvcatalogue.databinding.FragmentTvBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.NullPointerException


class TvFragment : Fragment() {

    private lateinit var tvBinding: FragmentTvBinding
    private lateinit var tvAdapter: TvAdapter
    val viewModel by viewModel<TvShowViewModel>()

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
        if (activity != null){
            /*val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]*/
            tvAdapter = TvAdapter()
            try {
                showLoading(true)
                viewModel.fetchTvShow()
                viewModel.getTvShow().observe(viewLifecycleOwner, {tvShowList ->
                    if (tvShowList!=null){

                        tvAdapter.setShow(tvShowList)

                        with(tvBinding.rvTvShow){
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                            adapter = tvAdapter
                            showLoading(false)
                        }
                    }
                })
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