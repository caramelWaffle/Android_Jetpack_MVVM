package com.example.totorial.demo.presenter.di

import androidx.fragment.app.Fragment
import com.example.totorial.MainApplication
import com.example.totorial.demo.presenter.view.MovieFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSupComponent {

    fun inject(movieFragment: MovieFragment)

    fun inject(app: MainApplication)

    @Subcomponent.Factory
    interface Factory{
        fun create(): MovieSupComponent
    }
}