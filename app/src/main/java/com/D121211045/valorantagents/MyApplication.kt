package com.D121211045.valorantagents

import android.app.Application
//import com.D121211045.valorantagents.data.AppContainer
//import com.D121211045.valorantagents.data.DefaultAppContainer
import com.makassar.newsappcompose.data.AppContainer
import com.makassar.newsappcompose.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}