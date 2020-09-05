package com.example.totorial.demo.presenter.di.core

import android.content.Context
import com.example.totorial.demo.presenter.di.MovieSupComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSupComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }

}