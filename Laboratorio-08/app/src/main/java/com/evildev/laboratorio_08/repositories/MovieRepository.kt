package com.evildev.laboratorio_08.repositories

import com.evildev.laboratorio_08.data.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies

    fun addMovie(movieModel: MovieModel) {
        movies.add(movieModel)
    }
}