package com.example.totorial.demo.presenter.di.core

import com.example.totorial.demo.data.repository.MovieRepository
import com.example.totorial.demo.domain.MovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository): MovieUseCase {
        return MovieUseCase(movieRepository)
    }

}