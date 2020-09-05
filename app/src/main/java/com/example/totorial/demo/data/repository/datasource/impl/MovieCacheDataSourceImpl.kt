package com.example.totorial.demo.data.repository.datasource.impl

import com.example.totorial.demo.data.repository.datasource.MovieCacheDataSource
import test_code.data.model.Movie


class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
       movieList.clear()
       movieList = ArrayList(movies)
    }
}