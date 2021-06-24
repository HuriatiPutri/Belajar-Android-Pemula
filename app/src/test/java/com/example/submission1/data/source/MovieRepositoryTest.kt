package com.example.submission1.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.submission1.data.apiservice.ApiConfig
import com.example.submission1.data.source.remote.ApiResponse
import com.example.submission1.data.source.remote.RemoteDataSource
import com.example.submission1.data.source.remote.response.DetailMovieResponse
import com.example.submission1.data.source.remote.response.DetailTvResponse
import com.example.submission1.data.source.remote.response.MovieResponse
import com.example.submission1.data.source.remote.response.TvShowResponse
import com.example.submission1.utils.DataDummy
import com.example.submission1.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import retrofit2.Call
import retrofit2.Callback

class MovieRepositoryTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepository = FakeMovieRepositoryTest(remote)

    private val movieResponse : Call<MovieResponse>? = null
    private val tvshowResponses : Call<TvShowResponse>? = null
    private val detailMovieResponse : Call<DetailMovieResponse>? = null
    private val detailTvShowResponse : Call<DetailTvResponse>? = null

    @Test
    fun testGetDataMovie() {
        doAnswer { invocation ->
            if (movieResponse != null) {
                (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback)
                    .onAllMovieReceived(movieResponse)
            }
            null
        }.`when`(remote).getDataMovie(any())
        LiveDataTestUtil.getValue(academyRepository.getDataMovie())
        verify(remote).getDataMovie(any())
    }

    @Test
    fun testGetDataTvShow() {
        doAnswer { invocation ->
            if (tvshowResponses != null) {
                (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                    .onAllTvShowReceived(tvshowResponses)
            }
            null
        }.`when`(remote).getDataTvShow(any())
        LiveDataTestUtil.getValue(academyRepository.getDataTvShow())
        verify(remote).getDataTvShow(any())
    }

}