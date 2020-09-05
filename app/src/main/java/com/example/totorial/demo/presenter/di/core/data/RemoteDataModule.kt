package com.example.totorial.demo.presenter.di.core.data

import com.example.totorial.demo.data.api.APIService
import com.example.totorial.demo.data.repository.datasource.MovieRemoteDataSource
import com.example.totorial.demo.data.repository.datasource.impl.MovieRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val API_KEY : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: APIService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImp(tmdbService, API_KEY)
    }
}