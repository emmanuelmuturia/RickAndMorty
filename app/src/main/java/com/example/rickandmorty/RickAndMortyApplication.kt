package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.datalayer.AppContainer
import com.example.rickandmorty.datalayer.DefaultAppContainer

class RickAndMortyApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}