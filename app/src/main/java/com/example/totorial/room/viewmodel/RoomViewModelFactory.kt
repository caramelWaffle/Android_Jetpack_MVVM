package com.example.totorial.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.totorial.room.data.source.UserRepository

class RoomViewModelFactory(private val userRepository: UserRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RoomViewModel::class.java)){
            return RoomViewModel(userRepository) as T
        }

        throw IllegalArgumentException()
    }
}