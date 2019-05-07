package com.ayoprez.controlify.database

import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData
import io.reactivex.Single
import org.threeten.bp.LocalDate

interface IDatabaseManager {

    fun getCompleteListOfSessions(): Single<MutableList<SessionsData>>
    fun getCompleteListOfSessionsFromToday(): Single<SessionsData>
    fun getCompleteListOfSessionsByDate(date: LocalDate): Single<SessionsData>
    fun getLastCompleteListOfSessions(): SessionsData

    fun updateSessionsData(sessionsData: SessionsData)
    fun updateSession(session: Session)
    fun insertSessionsData(sessionsData: SessionsData)
    fun insertSession(session: Session)

    fun getLastSessionWithoutEnd()
}