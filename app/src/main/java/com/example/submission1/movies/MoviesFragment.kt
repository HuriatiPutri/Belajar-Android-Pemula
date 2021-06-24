package com.example.submission1.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submission1.data.source.remote.response.ResultsItem
import com.example.submission1.databinding.FragmentMoviesBinding
import com.example.submission1.viewModel.ViewModelFactory


class MoviesFragment : Fragment(), MovieFragmentCallback {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstant(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val moviesAdapter = MoviesAdapter(this)
            fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
            viewModel.getDataMovie().observe(viewLifecycleOwner) { movie ->
                fragmentMoviesBinding.progressBar.visibility = View.GONE
                moviesAdapter.setMovie(movie)
                moviesAdapter.notifyDataSetChanged()
                Log.e("data", movie.toString())
            }

            with(fragmentMoviesBinding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                fragmentMoviesBinding.rvMovie.layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }

    override fun onShareClick(movie: ResultsItem) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(movie.originalTitle)
                .startChooser()
        }
    }
}