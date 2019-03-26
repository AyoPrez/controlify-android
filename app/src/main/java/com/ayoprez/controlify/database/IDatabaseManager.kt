package com.ayoprez.controlify.database

import com.ayoprez.controlify.model.SessionsData
import org.threeten.bp.LocalDate

interface IDatabaseManager {

    fun getCompleteListOfSessions(): MutableList<SessionsData>
    fun getCompleteListOfSessionsFromToday(): SessionsData
    fun getCompleteListOfSessionsByDate(date: LocalDate): SessionsData
    fun getLastCompleteListOfSessions(): SessionsData

    fun updateSessionsData(sessionsData: SessionsData)

    fun getLastSessionWithoutEnd()
}