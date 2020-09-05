package com.example.totorial.demo.presenter.di.core.data

import com.example.totorial.demo.data.db.MovieDAO
import com.example.totorial.demo.data.repository.datasource.MovieLocalDataSource
import com.example.totorial.demo.data.repository.datasource.impl.MovieLocalDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDAO: MovieDAO): MovieLocalDataSource {
        return MovieLocalDataSourceImp(movieDAO)
    }

}