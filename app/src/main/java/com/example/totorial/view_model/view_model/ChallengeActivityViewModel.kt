package com.example.totorial.view_model.view_model

import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.totorial.MainApplication

class ChallengeActivityViewModel(score: Int) : ViewModel(), Observable{

    private var score = MutableLiveData<Int>()

    val scoreData : LiveData<Int>
    get() = this.score

    @Bindable
    var inputScore = MutableLiveData<String>()

    init {
        this.score.value = score
    }

    fun sumScore() {
        this.score.value = this.score.value?.plus(inputScore.value!!.toInt())
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}