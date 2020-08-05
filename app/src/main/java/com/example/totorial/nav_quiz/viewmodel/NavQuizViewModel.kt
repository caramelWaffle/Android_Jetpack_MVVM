package com.example.totorial.nav_quiz.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavQuizViewModel(name: String): ViewModel(), Observable{

    @Bindable
    var name = MutableLiveData<String>()

    private var age = MutableLiveData<Int>()

    val ageData : LiveData<Int>
        get() = this.age


    init {
        this.name.value = name
        this.age.value = 0
    }

    @Bindable
    var year = MutableLiveData<String>()

    fun getBirthYear(){
        this.age.value =  (2020 - (year.value!!.toInt()))
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}