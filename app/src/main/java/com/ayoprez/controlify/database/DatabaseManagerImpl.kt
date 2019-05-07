package com.ayoprez.controlify.database

import android.annotation.SuppressLint
import com.ayoprez.controlify.FormatTimeUtils
import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

class DatabaseManagerImpl : IDatabaseManager, KoinComponent {

    private val timeFormatTimeUtils: FormatTimeUtils = get()
    private val database: SessionDataDao by inject()

    override fun getCompleteListOfSessions(): Single<MutableList<SessionsData>> {
        return database.getAll()
    }

    override fun getLastSessionWithoutEnd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @SuppressLint("CheckResult")
    override fun getCompleteListOfSessionsFromToday(): Single<SessionsData> {
        return database.getSessionsDataByDate(timeFormatTimeUtils.getDateFromDateTime(LocalDateTime.now()))
            .map { todayDataSessions ->
                if (todayDataSessions.isEmpty()) {
                    val sessionsData = SessionsData()
                    sessionsData.day = timeFormatTimeUtils.getDateFromDateTime(LocalDateTime.now())

                    sessionsData
                } else {
                    todayDataSessions[0]
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
    }

    override fun getCompleteListOfSessionsByDate(date: LocalDate): Single<SessionsData> {
        return database.getSessionsDataByDate(date.toString())
            .map { result -> result[0] }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
    }

    override fun getLastCompleteListOfSessions(): SessionsData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateSessionsData(sessionsData: SessionsData) {
        database.updateSessions(sessionsData)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }

    @SuppressLint("CheckResult")
    override fun updateSession(session: Session) {
        database.updateSession(session)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe({
                System.out.println()
            }, {error ->
                System.out.println("Error: $error")
            })
    }

    override fun insertSessionsData(sessionsData: SessionsData) {
        database.insertSessions(sessionsData)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }

    override fun insertSession(session: Session) {
        database.insertSession(session)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }
}