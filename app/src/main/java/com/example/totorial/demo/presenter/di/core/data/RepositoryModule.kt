package com.example.totorial.demo.presenter.di.core.data

import com.example.totorial.demo.data.repository.MovieRepository
import com.example.totorial.demo.data.repository.MovieRepositoryImp
import com.example.totorial.demo.data.repository.datasource.MovieCacheDataSource
import com.example.totorial.demo.data.repository.datasource.MovieLocalDataSource
import com.example.totorial.demo.data.repository.datasource.MovieRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository = MovieRepositoryImp(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)

}