package com.example.informator

import android.app.Application
import com.example.informator.di.appModule
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}