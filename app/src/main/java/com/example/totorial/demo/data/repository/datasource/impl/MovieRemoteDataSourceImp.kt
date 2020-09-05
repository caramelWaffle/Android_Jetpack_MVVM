package com.example.totorial.demo.data.repository.datasource.impl


import com.example.totorial.demo.data.api.APIService
import com.example.totorial.demo.data.repository.datasource.MovieRemoteDataSource
import retrofit2.Response
import test_code.data.model.MovieList

class MovieRemoteDataSourceImp(private val tmdbService: APIService, private val API_KEY: String) :
    MovieRemoteDataSource {

    override suspend fun getMoviesFromRemote(): Response<MovieList> {
        return tmdbService.getPopularMovies(API_KEY)
    }
}