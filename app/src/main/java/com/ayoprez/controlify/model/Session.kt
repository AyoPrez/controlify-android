package com.ayoprez.controlify.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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

@Entity(foreignKeys = [ForeignKey(entity = SessionsData::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("id"),
    onDelete = ForeignKey.CASCADE)]
)
data class Session (
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var startSessionTime: String = "",
    var endSessionTime: String = "",
    var totalSessionTime: String = "",
    var sessionLevel: Int = -1
)