package com.example.totorial.nav_quiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NavQuizViewModelFactory(private var name: String): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // ViewModel
        if (modelClass.isAssignableFrom(NavQuizViewModel::class.java)){
            return NavQuizViewModel(this.name) as T
        }

        throw IllegalArgumentException()
    }

}