package com.ayoprez.controlify

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ayoprez.controlify.presenter.ReceiverPresenter
import org.koin.core.KoinComponent
import org.koin.core.get
import org.threeten.bp.LocalDateTime

class ScreenStateReceiver : BroadcastReceiver(), KoinComponent {

    private val receiverPresenter: ReceiverPresenter = get()

    override fun onReceive(context: Context?, intent: Intent?) {
        var screenOff = true

        if (intent!!.action == Intent.ACTION_SCREEN_ON) {
            val now = LocalDateTime.now().toString()
            System.out.println("##∞Screen is on")
            screenOff = false
        } else if (intent.action == Intent.ACTION_SCREEN_OFF){
            val now = LocalDateTime.now().toString()
            System.out.println("##∞Screen is off")
        }

        val i = Intent(context, UpdateService::class.java)
        i.putExtra("screen_state", screenOff)
        context!!.startService(i)
    }
}