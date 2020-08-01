package com.example.totorial.view_model.view_model

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.totorial.MainApplication

class ChallengeActivityViewModel : ViewModel() {
    private var score = 0

    fun getScore(): Int {
        return score
    }

    fun sumScore(score: String) {
        try {
            this.score += score.toInt()
        } catch (e: NumberFormatException) {
            Toast.makeText(Contextor.getContext(), "Insert Number", Toast.LENGTH_SHORT).show()
        }
    }
}