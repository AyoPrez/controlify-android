package com.ayoprez.controlify.database

import androidx.room.*
import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface SessionDataDao {

    @Query("SELECT * FROM sessionsdata")
    fun getAll(): Single<MutableList<SessionsData>>

    @Query("SELECT * FROM sessionsdata WHERE day IN (:date)")
    fun getSessionsDataByDate(date: String): Single<MutableList<SessionsData>>

    @Insert
    fun insertSessions(vararg sessionsData: SessionsData): Completable

    @Insert
    fun insertSession(vararg session: Session): Completable

    @Delete
    fun deleteSessions(sessionsData: SessionsData): Completable

    @Delete
    fun deleteSession(session: Session): Completable

    @Update
    fun updateSessions(sessionsData: SessionsData): Completable

    @Update
    fun updateSession(session: Session): Completable
}