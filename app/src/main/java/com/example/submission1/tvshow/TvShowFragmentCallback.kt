package com.example.submission1.tvshow

import com.example.submission1.data.source.remote.response.ResultsItemTv

interface TvShowFragmentCallback {
    fun onShareClick(tvshow: ResultsItemTv)
}