package com.ayoprez.controlify.database

import com.ayoprez.controlify.FormatTimeUtils
import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData
import org.koin.core.KoinComponent
import org.koin.core.get
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

class DatabaseManagerImpl : IDatabaseManager, KoinComponent {

    private val timeFormatTimeUtils: FormatTimeUtils = get()
    private val database: SessionDataDao = get()

    override fun getCompleteListOfSessions(): MutableList<SessionsData> {
        return database.getAll()
    }

    override fun getLastSessionWithoutEnd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompleteListOfSessionsFromToday(): SessionsData {
        val todayDataSessions = database.getSessionsDataByDate(timeFormatTimeUtils.getDateFromDateTime(LocalDateTime.now()))

        return if (todayDataSessions.isEmpty()) {
            val sessionsData = SessionsData()
            sessionsData.day = timeFormatTimeUtils.getDateFromDateTime(LocalDateTime.now())

            sessionsData
        } else {
            todayDataSessions[0]
        }
    }

    override fun getCompleteListOfSessionsByDate(date: LocalDate): SessionsData {
        return database.getSessionsDataByDate(date.toString())[0]
    }

    override fun getLastCompleteListOfSessions(): SessionsData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun updateSessionsData(sessionsData: SessionsData) {
        database.updateSessions(sessionsData)
    }

    override fun updateSession(session: Session) {
        database.updateSession(session)
    }

    override fun insertSessionsData(sessionsData: SessionsData) {
        database.insertSessions(sessionsData)
    }

    override fun insertSession(session: Session) {
        database.insertSession(session)
    }
}