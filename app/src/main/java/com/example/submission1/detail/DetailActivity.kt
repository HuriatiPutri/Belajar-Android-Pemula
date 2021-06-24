package com.example.submission1.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.submission1.R
import com.example.submission1.data.source.remote.response.DetailMovieResponse
import com.example.submission1.databinding.ActivityDetailBinding
import com.example.submission1.viewModel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding : ActivityDetailBinding
    companion object{
        const val EXTRA_DETAIL = "extra_detail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        val factory = ViewModelFactory.getInstant(applicationContext)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        setContentView(activityDetailBinding.root)

        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getInt(EXTRA_DETAIL)
            if(movieId != null){
                activityDetailBinding.progressBar.visibility = View.VISIBLE
                viewModel.setSelected(movieId)
                viewModel.getMovie().observe(this,
                    {
                        movie ->
                        activityDetailBinding.progressBar.visibility = View.GONE
                        getDetailMovie(movie)
                    })
            }
        }

    }

    private fun getDetailMovie(movie: DetailMovieResponse) {
        activityDetailBinding.txtTitle.text = movie.title
        activityDetailBinding.txtTagline.text = movie.tagline
        activityDetailBinding.txtDate.text = movie.releaseDate
        activityDetailBinding.txtScore.text = movie.voteAverage.toString()
        activityDetailBinding.txtDesc.text = movie.overview
        activityDetailBinding.txtStatus.text = movie.status
        activityDetailBinding.txtLg.text = movie.originalLanguage
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+movie.posterPath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(activityDetailBinding.imgPoster)

    }

    fun back(view: View) {
        finish()
    }
}