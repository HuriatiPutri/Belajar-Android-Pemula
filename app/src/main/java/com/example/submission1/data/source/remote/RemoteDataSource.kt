package com.example.submission1.data.source.remote

import android.os.Handler
import android.os.Looper
import com.example.submission1.data.apiservice.ApiConfig
import com.example.submission1.data.source.remote.response.*
import com.example.submission1.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback

class RemoteDataSource private constructor(private val apiConfig: ApiConfig){
    private var APIKEY = "9002eea5e03b905cf981e82dffcc1630"

    private var handler = Handler(Looper.getMainLooper())
    companion object{
        private const val SERVICE_LATENCY_IN_MILIS : Long = 2000
        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance(apiConfig: ApiConfig): RemoteDataSource =
            instance?: synchronized(this){
                instance?:RemoteDataSource(apiConfig).apply { instance = this }
            }
    }

    fun getDataMovie(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMovieReceived(ApiConfig.getApiService().getMovies(APIKEY, "EN",1))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILIS)
    }

    fun getDetailMovie(movieId: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onDetailMovieReceived(ApiConfig.getApiService().getDetailMovie(movieId, APIKEY, "en-US"))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILIS)
    }

    fun getDataTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllTvShowReceived(ApiConfig.getApiService().getTvShow(APIKEY, "en-US", 1))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILIS)
    }

    fun getDetailTv(tvId: Int, callback: LoadDetailTvCallback) {
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onDetailTvReceived(ApiConfig.getApiService().getDetailTv(tvId, APIKEY, "en-US"))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILIS)
    }


    interface LoadMovieCallback{
        fun onAllMovieReceived(movieResponse: Call<MovieResponse>)
    }
    interface LoadDetailMovieCallback{
        fun onDetailMovieReceived(detailMovieResponse : Call<DetailMovieResponse>)
    }
    interface LoadTvShowCallback{
        fun onAllTvShowReceived(tvShowResponse: Call<TvShowResponse>)
    }
    interface LoadDetailTvCallback{
        fun onDetailTvReceived(detailTvResponse : Call<DetailTvResponse>)
    }
}