package com.example.totorial.view_model.view_model

import androidx.lifecycle.ViewModel

class ViewModelActivityViewModel : ViewModel(){
    private var count: Int = 0

    fun getCounter(): Int{
        return count
    }

    fun updateCounter(){
         count++
    }
}