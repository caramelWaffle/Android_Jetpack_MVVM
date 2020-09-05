package com.example.totorial.demo.domain

import com.example.totorial.demo.data.repository.MovieRepository
import test_code.data.model.Movie

class MovieUseCase(private val movieRepository: MovieRepository) {

    suspend fun getMovies(): List<Movie>? = movieRepository.getMovies()

    suspend fun updateMovies(): List<Movie>? = movieRepository.updateMovies()


}