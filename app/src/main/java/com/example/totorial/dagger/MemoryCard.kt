package com.example.totorial.dagger

import android.util.Log
import javax.inject.Inject

// Assume that MemoryCard is 3rd lib
class MemoryCard {
    init {
        Log.i("MYTAG","Memory Card Constructed")
    }

    fun getSpaceAvailablity(){
        Log.i("MYTAG","Memory space available")
    }
}