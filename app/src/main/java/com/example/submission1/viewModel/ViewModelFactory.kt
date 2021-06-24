package com.example.submission1.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submission1.data.source.MovieRepository
import com.example.submission1.detail.DetailViewModel
import com.example.submission1.di.Injection
import com.example.submission1.movies.MovieViewModel
import com.example.submission1.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstant(context: Context) : ViewModelFactory =
                instance?: synchronized(this){
                    instance?: ViewModelFactory(Injection.provideRepository(context)).apply {
                        instance = this
                    }
                }
    }

    @Suppress("UNCHEKED_CASR")
    override fun<T : ViewModel> create(modelClass : Class<T>) : T{
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) ->{
                return DetailViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknow ViewModel Class : " + modelClass.name)
        }
    }
}