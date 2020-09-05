package com.example.totorial.demo.presenter.di.core.data

import com.example.totorial.demo.data.repository.datasource.MovieCacheDataSource
import com.example.totorial.demo.data.repository.datasource.impl.MovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }
}