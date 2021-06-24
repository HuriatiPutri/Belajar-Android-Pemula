package com.example.submission1.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.data.source.remote.response.ResultsItem

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getDataMovie() : LiveData<List<ResultsItem>> = movieRepository.getDataMovie()
}