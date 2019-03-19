package com.ayoprez.controlify.presenter

import com.ayoprez.controlify.database.IDatabaseManager
import com.ayoprez.controlify.model.Session
import org.koin.core.KoinComponent
import org.threeten.bp.Duration
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit

class ReceiverPresenter(val databaseManager: IDatabaseManager): KoinComponent {

    //private lateinit var databaseManager: IDatabaseManager
//    private val databaseManager: IDatabaseManager = get()

    //LocalDateTime -> 2019-03-12T22:02:39.675

    private val timePattern = "HH:mm:ss"

    fun introduceDateInDatabase(dateTime: LocalDateTime) {
        //If there is already sessions with this date, don't introduce it
        getDateFromDateTime(dateTime)
    }

    fun introduceStartSessionTimeInDatabase(dateTime: LocalDateTime) {
        val sessionsFromToday = databaseManager.getCompleteListOfSessionsFromToday()

        val newSession = Session()
        newSession.startSessionTime = getTimeFromDateTime(dateTime)

        sessionsFromToday.sessions.add(newSession)

        databaseManager.updateSessionsData(sessionsFromToday)
    }

    fun introduceEndSessionTimeInDatabase(dateTime: LocalDateTime) {
        getTimeFromDateTime(dateTime)
    }

    fun introduceTotalSessionTimeInDatabase() {
        val sessionsFromToday = databaseManager.getCompleteListOfSessionsFromToday()

        for (session in sessionsFromToday.sessions) {
            if (session.totalSessionTime.isEmpty() || session.totalSessionTime.isBlank()){
                session.totalSessionTime = calculateTotalTimeOfSession(session.startSessionTime, session.endSessionTime)
            }
        }

        databaseManager.updateSessionsData(sessionsFromToday)
    }

    fun introduceTotalDaySessionTimeInDatabase() {
        val sessionsFromToday = databaseManager.getCompleteListOfSessionsFromToday()
        sessionsFromToday.totalDayTime = calculateTotalTimeOfDay(sessionsFromToday.sessions)

        databaseManager.updateSessionsData(sessionsFromToday)
    }

    fun getDateFromDateTime(dateTime: LocalDateTime): String {
        return "${dateTime.dayOfMonth}/0${dateTime.monthValue}/${dateTime.year}"
    }

    fun getTimeFromDateTime(dateTime: LocalDateTime): String {
        val time = "${dateTime.hour}:0${dateTime.minute}:${dateTime.second}"
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