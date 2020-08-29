package com.example.totorial

import Contextor
import android.app.Application
import android.content.Context
import com.example.totorial.dagger.DaggerSmartPhoneComponent
import com.example.totorial.dagger.MemoryCardModule
import com.example.totorial.dagger.SmartPhoneComponent

class MainApplication : Application(){

    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        super.onCreate()
        Contextor.setContext(applicationContext)
        smartPhoneComponent = initDagger()
    }

    private fun initDagger(): SmartPhoneComponent =
        DaggerSmartPhoneComponent.builder()
            .memoryCardModule(MemoryCardModule())
            .build()

}