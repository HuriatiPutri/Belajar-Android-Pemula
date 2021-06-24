package com.example.submission1.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.data.source.remote.response.ResultsItemTv

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getDataTvShow() : LiveData<List<ResultsItemTv>> = movieRepository.getDataTvShow()
}