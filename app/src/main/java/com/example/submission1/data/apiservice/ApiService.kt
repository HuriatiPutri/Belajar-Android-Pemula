package com.example.submission1.data.apiservice

import com.example.submission1.data.source.remote.response.DetailMovieResponse
import com.example.submission1.data.source.remote.response.DetailTvResponse
import com.example.submission1.data.source.remote.response.MovieResponse
import com.example.submission1.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovies(@Query("api_key") apikey : String,
                      @Query ("language") language : String, @Query("page") page : Int)
            : Call<MovieResponse>

    @GET("movie/{id}")
    fun getDetailMovie(@Path("id") id : Int,@Query("api_key") page : String,
                      @Query ("language") language : String)
            : Call<DetailMovieResponse>

    @GET("tv/popular")
    fun getTvShow(@Query("api_key") apikey : String,
                  @Query ("language") language : String, @Query("page") page : Int)
            : Call<TvShowResponse>

    @GET("tv/{id}")
    fun getDetailTv(@Path("id") id : Int,@Query("api_key") page : String,
                       @Query ("language") language : String)
            : Call<DetailTvResponse>

}