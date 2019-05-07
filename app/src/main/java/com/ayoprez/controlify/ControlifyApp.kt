package com.ayoprez.controlify

import android.app.Application
import com.ayoprez.controlify.di.controlifyAppModule
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ControlifyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(controlifyAppModule).androidContext(applicationContext)
        }

        AndroidThreeTen.init(this)
        Stetho.initializeWithDefaults(this)
    }

}