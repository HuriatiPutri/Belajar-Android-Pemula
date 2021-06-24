package com.example.submission1.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.data.source.remote.response.ResultsItem
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
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<ResultsItem>>

    @Before
    fun setup(){
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getCourses(){
        val dummyCourses = DataDummy.getResultsItemMovie()
        val courses = MutableLiveData<List<ResultsItem>>()
        courses.value = dummyCourses
        `when`(movieRepository.getDataMovie()).thenReturn(courses)
        val courseEntities = viewModel.getDataMovie().value
        verify(movieRepository).getDataMovie()
        assertNotNull(courseEntities)
        assertEquals(1, courseEntities?.size)

        viewModel.getDataMovie().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}