package com.example.submission1.di

import android.content.Context
import com.example.submission1.data.apiservice.ApiConfig
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.data.source.remote.RemoteDataSource
import com.example.submission1.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context) : MovieRepository{
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig())
        return MovieRepository.getInstance(remoteDataSource)
    }
}