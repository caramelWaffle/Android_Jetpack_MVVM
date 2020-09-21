package com.example.totorial.view_model_live_data.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val score: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // ViewModel
        if (modelClass.isAssignableFrom(ChallengeActivityViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return ChallengeActivityViewModel(this.score) as T
        }

        throw IllegalArgumentException()
    }

}