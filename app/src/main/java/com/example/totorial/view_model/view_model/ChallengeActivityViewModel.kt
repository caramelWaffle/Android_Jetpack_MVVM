package com.example.totorial.view_model.view_model

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.totorial.MainApplication

class ChallengeActivityViewModel(score: Int) : ViewModel() {
    private var score = MutableLiveData<Int>()


    init {
        this.score.value = score
    }

    fun getScore():MutableLiveData<Int>{
        return this.score
    }

    fun sumScore(score: String) {
        try {
            this.score.value = this.score.value?.plus(score.toInt())
        } catch (e: NumberFormatException) {
            Toast.makeText(Contextor.getContext(), "Insert Number", Toast.LENGTH_SHORT).show()
        }
    }
}