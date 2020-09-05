package com.example.totorial.demo.presenter.di

import com.example.totorial.demo.domain.MovieUseCase
import com.example.totorial.demo.presenter.viewmodel.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieModule {

    @Provides
    @MovieScope
    fun provideMovieViewModelFactory(movieUseCase: MovieUseCase): MovieViewModelFactory {
        return MovieViewModelFactory(movieUseCase)
    }

}