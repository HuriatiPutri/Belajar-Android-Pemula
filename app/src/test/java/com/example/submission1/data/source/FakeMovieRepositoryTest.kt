package com.example.submission1.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submission1.data.source.remote.RemoteDataSource
import com.example.submission1.data.source.remote.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FakeMovieRepositoryTest (private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    override fun getDataMovie(): LiveData<List<ResultsItem>> {

        val movieResult = MutableLiveData<List<ResultsItem>>()
        remoteDataSource.getDataMovie(object : RemoteDataSource.LoadMovieCallback{
            override fun onAllMovieReceived(movieResponse: Call<MovieResponse>) {
                movieResponse.enqueue(object : Callback<MovieResponse>{
                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if(response.isSuccessful){
                            movieResult.postValue(response.body()?.results!! as List<ResultsItem>?)
                        }
                    }

                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.e("TAG", "Onfailure: ${t.message.toString()}")
                    }

                })
            }

        })
        return movieResult
    }

    override fun getDataTvShow(): LiveData<List<ResultsItemTv>> {
        val movieResult = MutableLiveData<List<ResultsItemTv>>()
        remoteDataSource.getDataTvShow(object : RemoteDataSource.LoadTvShowCallback{
            override fun onAllTvShowReceived(tvShowResponse: Call<TvShowResponse>) {
                tvShowResponse.enqueue(object : Callback<TvShowResponse>{
                    override fun onResponse(
                        call: Call<TvShowResponse>,
                        response: Response<TvShowResponse>
                    ) {
                        movieResult.postValue(response.body()?.results!! as List<ResultsItemTv>?)
                    }

                    override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                        Log.e("TAG", "Onfailure: ${t.message.toString()}")
                    }

                })
            }


        })
        return movieResult
    }

    override fun getMovie(movieId: Int): LiveData<DetailMovieResponse> {
        val movieResult = MutableLiveData<DetailMovieResponse>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadDetailMovieCallback{
            override fun onDetailMovieReceived(detailMovieResponse: Call<DetailMovieResponse>) {
                detailMovieResponse.enqueue(object : Callback<DetailMovieResponse>{
                    override fun onResponse(
                        call: Call<DetailMovieResponse>,
                        response: Response<DetailMovieResponse>
                    ) {
                        if(response.isSuccessful){
                            movieResult.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                        Log.e("TAG", "Onfailure: ${t.message.toString()}")
                    }

                })
            }

        })
        return movieResult
    }

    override fun getTvShow(TvShowId: Int): LiveData<DetailTvResponse> {
        val movieResult = MutableLiveData<DetailTvResponse>()
        remoteDataSource.getDetailTv(TvShowId, object : RemoteDataSource.LoadDetailTvCallback{
            override fun onDetailTvReceived(detailMovieResponse: Call<DetailTvResponse>) {
                detailMovieResponse.enqueue(object : Callback<DetailTvResponse>{
                    override fun onResponse(
                        call: Call<DetailTvResponse>,
                        response: Response<DetailTvResponse>
                    ) {
                        if(response.isSuccessful){
                            movieResult.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<DetailTvResponse>, t: Throwable) {
                        Log.e("TAG", "Onfailure: ${t.message.toString()}")
                    }

                })
            }

        })
        return movieResult
    }
}