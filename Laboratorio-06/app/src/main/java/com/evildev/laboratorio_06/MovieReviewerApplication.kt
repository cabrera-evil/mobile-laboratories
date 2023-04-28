package com.evildev.laboratorio_06

import android.app.Application
import com.evildev.laboratorio_06.data.movies
import com.evildev.laboratorio_06.repositories.MoviesRepository

class MovieReviewerApplication: Application() {
    val moviesRepository: MoviesRepository by lazy {
        MoviesRepository(movies)
    }
}