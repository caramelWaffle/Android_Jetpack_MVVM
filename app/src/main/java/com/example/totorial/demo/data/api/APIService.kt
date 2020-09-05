package com.example.totorial.demo.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import test_code.data.model.MovieList

interface APIService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")
        APIKey: String): Response<MovieList>

}