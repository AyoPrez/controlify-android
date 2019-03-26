package com.ayoprez.controlify.database

import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData
import org.threeten.bp.LocalDate

interface IDatabaseManager {

    fun getCompleteListOfSessions(): MutableList<SessionsData>
    fun getCompleteListOfSessionsFromToday(): SessionsData
    fun getCompleteListOfSessionsByDate(date: LocalDate): SessionsData
    fun getLastCompleteListOfSessions(): SessionsData

    fun updateSessionsData(sessionsData: SessionsData)
    fun updateSession(session: Session)
    fun insertSessionsData(sessionsData: SessionsData)
    fun insertSession(session: Session)

    fun getLastSessionWithoutEnd()
}