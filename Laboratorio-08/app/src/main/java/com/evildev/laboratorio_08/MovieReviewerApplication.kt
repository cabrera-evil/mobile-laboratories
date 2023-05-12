package com.evildev.laboratorio_08

import android.app.Application
import com.evildev.laboratorio_08.data.movies
import com.evildev.laboratorio_08.repositories.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}