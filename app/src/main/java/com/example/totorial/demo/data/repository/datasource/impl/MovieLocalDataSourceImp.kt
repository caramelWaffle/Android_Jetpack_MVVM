package com.example.totorial.demo.data.repository.datasource.impl

import com.example.totorial.demo.data.db.MovieDAO
import com.example.totorial.demo.data.repository.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import test_code.data.model.Movie

class MovieLocalDataSourceImp(private val movieDAO: MovieDAO) :
    MovieLocalDataSource {

    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}