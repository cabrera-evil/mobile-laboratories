package com.evildev.laboratorio_07.ui.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.evildev.laboratorio_07.MovieReviewerApplication
import com.evildev.laboratorio_07.data.MovieModel
import com.evildev.laboratorio_07.repositories.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    //    LiveData values
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies() = movieRepository.getMovies()
    fun addMovie(movie: MovieModel) = movieRepository.addMovie(movie)

    fun createMovie() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addMovie(movie)
        status.value = MOVIE_CREATED
    }

    //    Validating data
    fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    //    Clearing data
    fun clearData() {
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    //    Clearing status
    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = "Inactive"
    }
}