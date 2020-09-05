package com.example.totorial.demo.data.repository.datasource

import test_code.data.model.Movie


interface MovieCacheDataSource {

    suspend fun getMoviesFromCache(): List<Movie>

    suspend fun saveMoviesToCache(movies: List<Movie>)}