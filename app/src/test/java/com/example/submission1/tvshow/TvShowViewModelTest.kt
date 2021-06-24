package com.example.submission1.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.data.source.remote.response.ResultsItemTv
import com.example.submission1.utils.DataDummy
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest{
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<ResultsItemTv>>

    @Before
    fun setup(){
        viewModel = TvShowViewModel(movieRepository)
    }

    @Test
    fun getTvShow(){
        val dummyCourses = DataDummy.getResultsItemTv()
        val courses = MutableLiveData<List<ResultsItemTv>>()
        courses.value = dummyCourses
        Mockito.`when`(movieRepository.getDataTvShow()).thenReturn(courses)
        val courseEntities = viewModel.getDataTvShow().value
        Mockito.verify(movieRepository).getDataTvShow()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(1, courseEntities?.size)

        viewModel.getDataTvShow().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyCourses)
    }
}