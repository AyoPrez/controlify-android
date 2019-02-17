package com.ayoprez.controlify

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class ControlifyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        //startKoin(this, )
        AndroidThreeTen.init(this)
    }
}