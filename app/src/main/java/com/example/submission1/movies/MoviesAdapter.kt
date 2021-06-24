package com.example.submission1.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submission1.R
import com.example.submission1.data.source.remote.response.ResultsItem
import com.example.submission1.databinding.ItemsMoviesBinding
import com.example.submission1.detail.DetailActivity

class MoviesAdapter(private val callback: MovieFragmentCallback) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<ResultsItem>()

    fun setMovie(movie : List<ResultsItem>?){
        if(movie == null)
            return this.listMovie.clear()
        this.listMovie.addAll(movie)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MovieViewHolder {
       val itemsMoviesBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMoviesBinding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MoviesAdapter.MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    inner class MovieViewHolder(private val binding : ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie : ResultsItem){
            with(binding){
                txtItemTitle.text = movie.title
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, movie.id)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(movie) }
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500/"+movie.posterPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgPoster)
            }
        }
    }
}