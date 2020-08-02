package com.example.totorial.view_model.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelActivityViewModel : ViewModel(){
    private var count = MutableLiveData<Int>()
    init {
        count.value = 1
    }
    fun getCount():MutableLiveData<Int>{
        return this.count
    }

    fun increaseCount(){
        this.count.value = this.count.value?.plus(1)
    }
}