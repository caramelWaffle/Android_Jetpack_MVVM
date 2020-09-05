package com.example.totorial.demo.data.repository.datasource

import retrofit2.Response
import test_code.data.model.MovieList

interface MovieRemoteDataSource {

    suspend fun getMoviesFromRemote(): Response<MovieList>
}