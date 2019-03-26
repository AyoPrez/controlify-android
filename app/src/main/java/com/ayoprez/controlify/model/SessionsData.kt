package com.ayoprez.controlify.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Day
* The day with the format dd/M/yyyy where the session happens
*
* TotalDayTime
* The total amount of time spend in the phone the indicated day. Use the format HH:mm:ss
*
* */

@Entity
data class SessionsData (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var day:  String = "",
    var totalDayTime: String = "",
    var sessions: ArrayList<Session> = arrayListOf()
)