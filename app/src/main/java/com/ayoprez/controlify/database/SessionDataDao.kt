package com.ayoprez.controlify.database

import androidx.room.*
import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData

@Dao
interface SessionDataDao {

    @Query("SELECT * FROM sessionsdata")
    fun getAll(): MutableList<SessionsData>

    @Query("SELECT * FROM sessionsdata WHERE day IN (:date)")
    fun getSessionsDataByDate(date: String): MutableList<SessionsData>

    @Insert
    fun insertSessions(vararg sessionsData: SessionsData)

    @Insert
    fun insertSession(vararg session: Session)

    @Delete
    fun deleteSessions(sessionsData: SessionsData)

    @Delete
    fun deleteSession(session: Session)

    @Update
    fun updateSessions(sessionsData: SessionsData)

    @Update
    fun updateSession(session: Session)
}