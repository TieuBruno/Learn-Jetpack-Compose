package com.example.jetpackcomposeplayground

import android.app.Application
import com.example.jetpackcomposeplayground.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, com.example.jetpackcomposeplayground.data.di.dataModule)
        }
    }
}
