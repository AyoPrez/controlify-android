package com.ayoprez.controlify.database

import com.ayoprez.controlify.model.SessionsData

interface IDatabaseManager {

    fun getCompleteListOfSessionsFromToday(): SessionsData
    fun getCompleteListOfSessionsByDate(): SessionsData
    fun getLastCompleteListOfSessions(): SessionsData

    fun updateSessionsData(sessionsData: SessionsData)

    fun getLastSessionWithoutEnd()

}