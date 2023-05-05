package com.evildev.laboratorio_07

import android.app.Application
import com.evildev.laboratorio_07.data.movies
import com.evildev.laboratorio_07.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}