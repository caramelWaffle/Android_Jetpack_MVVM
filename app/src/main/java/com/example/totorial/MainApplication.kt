package com.example.totorial

import Contextor
import android.app.Application
import com.example.totorial.dagger.DaggerSmartPhoneComponent
import com.example.totorial.dagger.MemoryCardModule
import com.example.totorial.dagger.SmartPhoneComponent
import com.example.totorial.demo.presenter.di.Injector
import com.example.totorial.demo.presenter.di.MovieSupComponent
import com.example.totorial.demo.presenter.di.core.AppComponent
import com.example.totorial.demo.presenter.di.core.AppModule
import com.example.totorial.demo.presenter.di.core.DaggerAppComponent
import com.example.totorial.demo.presenter.di.core.NetModule
import com.example.totorial.demo.presenter.di.core.data.RemoteDataModule

class MainApplication : Application(), Injector{

    lateinit var appComponent: AppComponent
    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        super.onCreate()
        Contextor.setContext(applicationContext)
        initDagger()
    }


    override fun initDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.themoviedb.org/3/"))
            .remoteDataModule(RemoteDataModule("0ee024a1abb59d09999850210c15495f"))
            .build()

        smartPhoneComponent =
            DaggerSmartPhoneComponent.builder()
                .memoryCardModule(MemoryCardModule())
                .build()
    }


    override fun createMovieSubComponent(): MovieSupComponent {
        return appComponent.movieSubComponent().create()
    }

}