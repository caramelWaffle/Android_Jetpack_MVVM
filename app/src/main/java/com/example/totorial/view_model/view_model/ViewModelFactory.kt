package com.example.totorial.view_model.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.view_model.activity.ViewModelChallengeActivity
import com.example.totorial.view_model.fragment.ChallengeFragment

class ViewModelFactory(private val score: Int): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // Activity
        if (modelClass.isAssignableFrom(ChallengeActivityViewModel::class.java)){
            return ChallengeActivityViewModel(this.score) as T
        }

        throw IllegalArgumentException()
    }

}