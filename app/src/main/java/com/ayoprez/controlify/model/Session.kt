package com.ayoprez.controlify.model

import com.orm.SugarRecord

/*
*
* StartSessionTime
* The time when a session is started. It has the format HH:mm:ss
*
* EndSessionTime
* The time when a session is finished. It has the format HH:mm:ss
*
* TotalSessionTime
* The total time of the session. It's the EndSessionTime - StartSessionTime
*
* SessionLevel
* Depending of how much time took the session, it has a different level. It's use to display different emojis
*
* */

data class Session (
    var startSessionTime: String = "",
    var endSessionTime: String = "",
    var totalSessionTime: String = "",
    var sessionLevel: Int = -1
): SugarRecord()