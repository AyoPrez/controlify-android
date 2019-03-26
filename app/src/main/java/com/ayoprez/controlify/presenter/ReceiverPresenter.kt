package com.ayoprez.controlify.presenter

import com.ayoprez.controlify.FormatTimeUtils
import com.ayoprez.controlify.database.IDatabaseManager
import com.ayoprez.controlify.model.Session
import org.koin.core.KoinComponent
import org.threeten.bp.LocalDateTime

class ReceiverPresenter(private val databaseManager: IDatabaseManager, private val timeFormatUtils: FormatTimeUtils): KoinComponent {

    fun introduceDateInDatabase(dateTime: LocalDateTime) {
        //If there is already sessions with this date, don't introduce it
        timeFormatUtils.getDateFromDateTime(dateTime)
    }

    fun introduceStartSessionTimeInDatabase(dateTime: LocalDateTime) {
        val sessionsFromToday = databaseManager.getCompleteListOfSessionsFromToday()

        val newSession = Session()
        newSession.startSessionTime = timeFormatUtils.getTimeFromDateTime(dateTime)

        sessionsFromToday.sessions.add(newSession)

        databaseManager.updateSession(newSession)

        databaseManager.updateSessionsData(sessionsFromToday)
    }

    fun introduceEndSessionTimeInDatabase(dateTime: LocalDateTime) {
        val sessionsFromToday = databaseManager.getCompleteListOfSessionsFromToday()

        val sessions = sessionsFromToday.sessions

        if (sessions.isEmpty()) {
            val session = Session(0,"", timeFormatUtils.getTimeFromDateTime(dateTime), "", 0)
            databaseManager.insertSession(session)

            sessions.add(session)

            sessionsFromToday.sessions = sessions

            databaseManager.insertSessionsData(sessionsFromToday)
        } else {
            //Should be tested that the uncompleted session (session with only beginning, the current session) is the last and not the first
            val session = sessions.last()

            session.endSessionTime = timeFormatUtils.getTimeFromDateTime(dateTime)

            databaseManager.updateSession(session)

//            databaseManager.updateSessionsData(sessionsFromToday)
        }
    }

    fun introduceTotalSessionTimeInDatabase() {
        val sessionsFromToday = databaseManager.getCompleteListOfSessionsFromToday()

        for (session in sessionsFromToday.sessions) {
            if (session.totalSessionTime.isEmpty() || session.totalSessionTime.isBlank()){
                session.totalSessionTime = timeFormatUtils.calculateTotalTimeOfSession(session.startSessionTime, session.endSessionTime)
                databaseManager.updateSession(session)
            }
        }

        databaseManager.updateSessionsData(sessionsFromToday)
    }

    fun introduceTotalDaySessionTimeInDatabase() {
        val sessionsFromToday = databaseManager.getCompleteListOfSessionsFromToday()
        sessionsFromToday.totalDayTime = timeFormatUtils.calculateTotalTimeOfDay(sessionsFromToday.sessions)

        databaseManager.updateSessionsData(sessionsFromToday)
    }
}