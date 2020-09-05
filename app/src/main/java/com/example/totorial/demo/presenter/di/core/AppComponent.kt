package com.example.totorial.demo.presenter.di.core

import com.example.totorial.demo.presenter.di.MovieSupComponent
import com.example.totorial.demo.presenter.di.core.data.CacheDataModule
import com.example.totorial.demo.presenter.di.core.data.LocalDataModule
import com.example.totorial.demo.presenter.di.core.data.RemoteDataModule
import com.example.totorial.demo.presenter.di.core.data.RepositoryModule
import com.example.totorial.demo.presenter.di.core.database.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
    AppModule::class,
    NetModule::class,
    DatabaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class,
    CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSupComponent.Factory
}