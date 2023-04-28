package com.evildev.laboratorio_06.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.evildev.laboratorio_06.MovieReviewerApplication
import com.evildev.laboratorio_06.data.Movie
import com.evildev.laboratorio_06.repositories.MoviesRepository

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {
    fun getMovies() = moviesRepository.getMovies()
    fun addMovie(movie: Movie) = moviesRepository.addMovie(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MoviesViewModel(app.moviesRepository)
            }
        }
    }
}