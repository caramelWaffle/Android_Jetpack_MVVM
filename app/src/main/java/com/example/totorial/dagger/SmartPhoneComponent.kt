package com.example.totorial.dagger

import com.example.totorial.dagger.view.DaggerActivity
import com.example.totorial.main.activity.MainActivity
import dagger.Component
import javax.inject.Singleton

// module for 3rd lib
@Singleton
@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {

    fun getSmartPhone(): SmartPhone

    fun inject(daggerActivity: DaggerActivity)

    fun inject(mainActivity: MainActivity)

}