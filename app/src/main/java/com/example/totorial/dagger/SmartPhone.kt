package com.example.totorial.dagger

import android.util.Log
import com.example.totorial.dagger.Battery
import com.example.totorial.dagger.MemoryCard
import com.example.totorial.dagger.SIMCard
import javax.inject.Inject

class SmartPhone @Inject constructor(val battery: Battery, val simCard: SIMCard, val memoryCard: MemoryCard) {

    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailablity()
        Log.i("MYTAG", "SmartPhone Constructed")
    }

    fun makeACallWithRecording() {
        Log.i("MYTAG", "Calling.....")
    }
}

