package com.example.totorial.demo.data.repository

import test_code.data.model.Movie


interface MovieRepository {
    // contact with DAO

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}