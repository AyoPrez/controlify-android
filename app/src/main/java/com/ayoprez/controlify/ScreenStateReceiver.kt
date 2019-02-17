package com.ayoprez.controlify

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ScreenStateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var screenOff = true

        if (intent!!.action == Intent.ACTION_SCREEN_ON) {
            System.out.println("##∞Screen is on")
            screenOff = false
        } else if (intent.action == Intent.ACTION_SCREEN_OFF){
            System.out.println("##∞Screen is off")
        }

        val i = Intent(context, UpdateService::class.java)
        i.putExtra("screen_state", screenOff)
        context!!.startService(i)
    }

}