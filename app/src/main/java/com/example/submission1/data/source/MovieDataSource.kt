package com.example.submission1.data.source

import androidx.lifecycle.LiveData
import com.example.submission1.data.source.remote.response.DetailMovieResponse
import com.example.submission1.data.source.remote.response.DetailTvResponse
import com.example.submission1.data.source.remote.response.ResultsItem
import com.example.submission1.data.source.remote.response.ResultsItemTv

interface MovieDataSource {
    fun getDataMovie() : LiveData<List<ResultsItem>>

    fun getDataTvShow() : LiveData<List<ResultsItemTv>>

    fun getMovie(movieId : Int) : LiveData<DetailMovieResponse>

    fun getTvShow(TvShowId : Int) : LiveData<DetailTvResponse>
}