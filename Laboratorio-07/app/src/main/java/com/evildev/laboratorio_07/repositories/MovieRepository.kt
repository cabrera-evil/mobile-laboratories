package com.evildev.laboratorio_07.repositories

import com.evildev.laboratorio_07.data.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies

    fun addMovie(movieModel: MovieModel) {
        movies.add(movieModel)
    }
}