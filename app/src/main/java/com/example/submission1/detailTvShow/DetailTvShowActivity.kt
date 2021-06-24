package com.example.submission1.detailTvShow

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.submission1.R
import com.example.submission1.data.source.remote.response.DetailTvResponse
import com.example.submission1.databinding.ActivityDetailTvBinding
import com.example.submission1.detail.DetailActivity
import com.example.submission1.detail.DetailViewModel
import com.example.submission1.viewModel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var activityDetailTvBinding: ActivityDetailTvBinding
    companion object{
        const val EXTRA_DETAIL = "extra_detail"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvBinding = ActivityDetailTvBinding.inflate(layoutInflater)
        val factory = ViewModelFactory.getInstant(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        setContentView(activityDetailTvBinding.root)

        val extras = intent.extras
        if(extras != null){
            val movieId = extras.getInt(DetailActivity.EXTRA_DETAIL)
            viewModel.setSelectedTvShow(movieId)
            activityDetailTvBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvShow().observe(this,
                {
                        movie ->
                    activityDetailTvBinding.progressBar.visibility = View.GONE
                    getDetailTvShow(movie)
                })
        }

    }

    private fun getDetailTvShow(movie: DetailTvResponse) {
        activityDetailTvBinding.txtTitle.text = movie.originalName
        activityDetailTvBinding.txtTagline.text = movie.tagline
        activityDetailTvBinding.txtDate.text = movie.firstAirDate
        activityDetailTvBinding.txtEpisode.text = movie.numberOfEpisodes.toString()
        activityDetailTvBinding.txtScore.text = movie.voteAverage.toString()
        activityDetailTvBinding.txtDesc.text = movie.overview
        activityDetailTvBinding.txtStatus.text = movie.status
        activityDetailTvBinding.txtLg.text = movie.originalLanguage
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+movie.posterPath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(activityDetailTvBinding.imgPoster)
}

    fun back(view: View) {
        finish()
    }
}