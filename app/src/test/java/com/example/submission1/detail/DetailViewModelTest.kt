package com.example.submission1.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.data.source.remote.response.DetailMovieResponse
import com.example.submission1.data.source.remote.response.DetailTvResponse
import com.example.submission1.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getDetailMovie()
    private val dummyTvShow = DataDummy.getDetailTv()
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<DetailMovieResponse>


    @Before
    fun setUp() {
        viewModel = DetailViewModel(movieRepository)
        viewModel.setSelected(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }


    @Test
    fun getMovie() {
        val course = MutableLiveData<DetailMovieResponse>()
        course.value = dummyMovie

        `when`(movieRepository.getMovie(movieId)).thenReturn(course)
        val movieEntity = viewModel.getMovie().value as DetailMovieResponse
        verify(movieRepository).getMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage)
    }

    @Test
    fun getTvShow() {
        val course = MutableLiveData<DetailTvResponse>()
        course.value = dummyTvShow

        `when`(movieRepository.getTvShow(tvShowId)).thenReturn(course)
        val movieEntity = viewModel.getTvShow().value as DetailTvResponse
        verify(movieRepository).getTvShow(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyTvShow.id, movieEntity.id)
        assertEquals(dummyTvShow.firstAirDate, movieEntity.firstAirDate)
        assertEquals(dummyTvShow.overview, movieEntity.overview)
        assertEquals(dummyTvShow.posterPath, movieEntity.posterPath)
        assertEquals(dummyTvShow.name, movieEntity.name)
        assertEquals(dummyTvShow.voteAverage, movieEntity.voteAverage)
    }


}