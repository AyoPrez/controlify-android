package com.ayoprez.controlify

import android.app.Application
import com.ayoprez.controlify.di.controlifyAppModule
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import com.orm.SugarContext
import org.koin.core.context.startKoin

class ControlifyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(controlifyAppModule)
        }

        AndroidThreeTen.init(this)
        SugarContext.init(this)
        Stetho.initializeWithDefaults(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        SugarContext.terminate()
    }
}