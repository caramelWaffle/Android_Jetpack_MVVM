package com.example.totorial.demo.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.totorial.demo.domain.MovieUseCase

class MovieViewModel(private val movieUseCase: MovieUseCase): ViewModel() {

    fun getMovies() = liveData {
        emit(movieUseCase.getMovies())
    }

    fun updateMovies() = liveData {
        emit(movieUseCase.updateMovies())
    }

}