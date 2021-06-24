package com.example.submission1.movies

import com.example.submission1.data.source.remote.response.ResultsItem

interface MovieFragmentCallback {
    fun onShareClick(movie: ResultsItem)
}