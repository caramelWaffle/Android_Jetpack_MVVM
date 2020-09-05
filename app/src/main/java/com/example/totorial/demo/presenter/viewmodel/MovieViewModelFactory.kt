package com.example.totorial.demo.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.demo.domain.MovieUseCase

class MovieViewModelFactory(private val movieUseCase: MovieUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieViewModel::class.java)){
            return MovieViewModel(movieUseCase) as T
        }
        throw IllegalArgumentException()
    }
}