package com.example.totorial

import Contextor
import android.app.Application
import android.content.Context

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        Contextor.setContext(applicationContext)
    }
}