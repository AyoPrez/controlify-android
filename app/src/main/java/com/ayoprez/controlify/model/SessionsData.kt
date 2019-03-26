package com.ayoprez.controlify.model

import com.orm.SugarRecord

/*
* Day
* The day with the format dd/M/yyyy where the session happens
*
* TotalDayTime
* The total amount of time spend in the phone the indicated day. Use the format HH:mm:ss
*
* */

data class SessionsData (
    var day:  String = "",
    var totalDayTime: String = "",
    var sessions: ArrayList<Session> = arrayListOf()
): SugarRecord()