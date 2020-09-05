package com.example.totorial.demo.presenter.di.core.database

import android.content.Context
import com.example.kotlin_mvvm_clean_architecture_demo.data.db.TMDBDatabase
import com.example.totorial.demo.data.db.MovieDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TMDBDatabase{
        return TMDBDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideMovieDao(database: TMDBDatabase): MovieDAO = database.movieDAO()
}