package com.example.submission1.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.data.source.remote.response.DetailMovieResponse
import com.example.submission1.data.source.remote.response.DetailTvResponse
import kotlin.properties.Delegates

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private var movieId by Delegates.notNull<Int>()
    private var tvShowId by Delegates.notNull<Int>()

    fun setSelected(movieId : Int){
        this.movieId = movieId
    }

    fun setSelectedTvShow(tvShowId : Int){
        this.tvShowId = tvShowId
    }

    fun getMovie() : LiveData<DetailMovieResponse> = movieRepository.getMovie(movieId)
    fun getTvShow() : LiveData<DetailTvResponse> = movieRepository.getTvShow(tvShowId)

}