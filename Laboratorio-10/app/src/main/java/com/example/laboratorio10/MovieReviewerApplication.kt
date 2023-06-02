package com.example.laboratorio10

import android.app.Application
import com.example.laboratorio10.data.MovieReviewerDatabase
import com.example.laboratorio10.repositories.ActorRepository
import com.example.laboratorio10.repositories.CastRepository
import com.example.laboratorio10.repositories.MovieRepository

class MovieReviewerApplication : Application() {

    private val database: MovieReviewerDatabase by lazy {
        MovieReviewerDatabase.newInstance(this)
    }
    val movieRepository: MovieRepository by lazy {
        MovieRepository(database.movieDao())
    }
    val actorRepository: ActorRepository by lazy {
        ActorRepository(database.actorDao())
    }
    val castRepository: CastRepository by lazy {
        CastRepository(database.castDao())
    }
}