package com.ayoprez.controlify

import android.app.Application
import com.ayoprez.controlify.di.controlifyAppModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.core.context.startKoin

class ControlifyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(controlifyAppModule)
        }

        AndroidThreeTen.init(this)
    }
}