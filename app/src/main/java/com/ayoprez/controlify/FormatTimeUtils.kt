package com.ayoprez.controlify

import com.ayoprez.controlify.model.Session
import org.threeten.bp.Duration
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit

class FormatTimeUtils {

    //LocalDateTime -> 2019-03-12T22:02:39.675

    private val timePattern = "HH:mm:ss"

    fun getDateFromDateTime(dateTime: LocalDateTime): String {
        val day = if (dateTime.dayOfMonth.toString().length == 1) { "0${dateTime.dayOfMonth}" } else { "${dateTime.dayOfMonth}" }
        val month = if (dateTime.monthValue.toString().length == 1) { "0${dateTime.monthValue}" } else { "${dateTime.monthValue}" }

        return "$day/$month/${dateTime.year}"
    }

    fun getTimeFromDateTime(dateTime: LocalDateTime): String {
        val hour = if (dateTime.hour.toString().length == 1) { "0${dateTime.hour}" } else { "${dateTime.hour}" }
        val minute = if (dateTime.minute.toString().length == 1) { "0${dateTime.minute}" } else { "${dateTime.minute}" }
        val seconds = if (dateTime.second.toString().length == 1) { "0${dateTime.second}" } else { "${dateTime.second}" }

        val time = "$hour:$minute:$seconds"
        return LocalTime.parse(time, DateTimeFormatter.ofPattern(timePattern)).toString()
    }

    fun calculateTotalTimeOfSession(sessionStart: String, sessionEnd: String): String {
        val startingSession = LocalTime.parse(sessionStart, DateTimeFormatter.ofPattern(timePattern))
        val endingSession = LocalTime.parse(sessionEnd, DateTimeFormatter.ofPattern(timePattern))

        val duration = Duration.ofSeconds(ChronoUnit.SECONDS.between(startingSession, endingSession))

        val hours = duration.toHours()
        val minutes = duration.minusHours(hours).toMinutes()
        val seconds = duration.minusMinutes(minutes).seconds

        val totalTime = "$hours:$minutes:$seconds"

        return LocalTime.parse(totalTime, DateTimeFormatter.ofPattern("H:m:ss")).toString()
    }

    fun calculateTotalTimeOfDay(listOfSessions: MutableList<Session>) : String {
        var totalSessionTimeInSeconds = 0

        for (session in listOfSessions) {
            if (session.totalSessionTime.isNotEmpty() || session.totalSessionTime.isNotBlank()) {
                val sessionTime = LocalTime.parse(session.totalSessionTime, DateTimeFormatter.ofPattern(timePattern))

                totalSessionTimeInSeconds += sessionTime.toSecondOfDay()
            }
        }

        return if (totalSessionTimeInSeconds == 0){
            "0s"
        } else {
            val duration = Duration.ofSeconds(totalSessionTimeInSeconds.toLong())

            val hours = duration.toHours()
            val minutes = duration.minusHours(hours).toMinutes()
            val seconds = duration.minusMinutes(minutes).seconds

            val totalTime = "$hours:$minutes:$seconds"

            LocalTime.parse(totalTime, DateTimeFormatter.ofPattern("H:m:ss")).toString()
        }
    }

}