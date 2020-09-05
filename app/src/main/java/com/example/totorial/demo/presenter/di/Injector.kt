package com.example.totorial.demo.presenter.di


interface Injector {

    fun initDagger()

    fun createMovieSubComponent(): MovieSupComponent
    
}