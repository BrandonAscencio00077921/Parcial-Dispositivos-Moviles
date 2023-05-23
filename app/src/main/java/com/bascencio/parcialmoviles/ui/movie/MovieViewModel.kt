package com.bascencio.parcialmoviles.ui.movie

import android.text.Spannable.Factory
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.bascencio.parcialmoviles.MovieReviewerApplication
import com.bascencio.parcialmoviles.data.model.MovieModel
import com.bascencio.parcialmoviles.repositories.MovieRepository

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    var title = MutableLiveData("")
    var director = MutableLiveData("")

    fun getMovies() = repository.getMovies()

    private fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    fun createMovie(){
        if (!validateData()){
            return
        }
        val movie = MovieModel(
            title.value!!,
            director.value!!
        )
        addMovies(movie)
        clearData()
    }

    private fun clearData() {
        title.value = ""
        director.value = ""
    }

    private fun validateData(): Boolean {
        when {
            title.value.isNullOrEmpty() -> return false
            director.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun setSelectedMovie(movie: MovieModel){
        title.value = movie.title
        director.value = movie.director
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}