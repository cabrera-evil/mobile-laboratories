package com.example.laboratorio10.repositories

import com.example.laboratorio10.data.dao.MovieDao
import com.example.laboratorio10.data.model.MovieModel

class MovieRepository(private val moviesDao: MovieDao) {

    suspend fun getMovies() = moviesDao.getAllMovies()

    suspend fun addMovies(movie: MovieModel) = moviesDao.insertMovie(movie)

    suspend fun getMoviesWithActors(id: Int) = moviesDao.getMovieWithActorsById(id)

}