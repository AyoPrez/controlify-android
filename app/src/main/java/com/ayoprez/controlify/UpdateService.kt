package com.ayoprez.controlify

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder

class UpdateService: Service() {

    override fun onCreate() {
        super.onCreate()
        // REGISTER RECEIVER THAT HANDLES SCREEN ON AND SCREEN OFF LOGIC
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        val mReceiver = ScreenStateReceiver()
        registerReceiver(mReceiver, filter)
    }

    override fun onBind(intent: Intent?): IBinder? {
        val screenOn = intent!!.getBooleanExtra("screen_state", false)
        if (!screenOn) {
            System.out.println("##∞Screen is off 2")
        } else {
            System.out.println("##∞Screen is on 2")
        }

        return null
    }

}