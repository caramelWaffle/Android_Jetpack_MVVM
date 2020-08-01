package com.example.totorial

import android.app.Application
import android.content.Context

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
    }

    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }
}