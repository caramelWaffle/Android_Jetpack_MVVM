package com.example.totorial.twoway_binding.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.twoway_binding.activity.TwoWayBindingActivity

class TwoWayViewModelFactory(private var username: String): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(TwoWayViewModel::class.java)){
            return TwoWayViewModel(username) as T
        }
        throw IllegalArgumentException()
    }

}