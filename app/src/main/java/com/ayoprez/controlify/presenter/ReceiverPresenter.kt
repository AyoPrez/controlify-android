package com.ayoprez.controlify.presenter

import android.annotation.SuppressLint
import com.ayoprez.controlify.FormatTimeUtils
import com.ayoprez.controlify.database.IDatabaseManager
import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime

class ReceiverPresenter(private val timeFormatUtils: FormatTimeUtils) : KoinComponent {

    private val databaseManager: IDatabaseManager = get()

    fun introduceDateInDatabase(dateTime: LocalDateTime) {
        //If there is already sessions with this date, don't introduce it
        timeFormatUtils.getDateFromDateTime(dateTime)
    }

    @SuppressLint("CheckResult")
    fun introduceStartSessionTimeInDatabase(dateTime: LocalDateTime) {
        databaseManager.getCompleteListOfSessionsFromToday()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { sessionsFromToday ->
                    updateSessionWithNewStartData(sessionsFromToday, dateTime)
                },
                { error ->
                    /*Add getview to have access to the view and show an error dialog */
                    System.out.println("Error in ReceiverPresenter: $error")
                })
    }

    private fun updateSessionWithNewStartData(sessionsFromToday: SessionsData, dateTime: LocalDateTime) {
        val newSession = Session()
        newSession.startSessionTime = timeFormatUtils.getTimeFromDateTime(dateTime)

        sessionsFromToday.session.add(newSession)

        databaseManager.updateSession(newSession)

        databaseManager.updateSessionsData(sessionsFromToday)
    }

    @SuppressLint("CheckResult")
    fun introduceEndSessionTimeInDatabase(dateTime: LocalDateTime) {
        databaseManager.getCompleteListOfSessionsFromToday()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { sessionsFromToday ->
                    insertOrUpdateEndSession(sessionsFromToday, dateTime)
                },
                { error ->
                    /*Add getview to have access to the view and show an error dialog */
                    System.out.println("Error in ReceiverPresenter EndSession: $error")
                })
    }

    private fun insertOrUpdateEndSession(sessionsFromToday: SessionsData, dateTime: LocalDateTime) {
        val sessions = sessionsFromToday.session

        if (sessions.isEmpty()) {
            val session = Session(0, "", timeFormatUtils.getTimeFromDateTime(dateTime), "", 0)
            databaseManager.insertSession(session)

            sessions.add(session)

            sessionsFromToday.session = sessions

            databaseManager.insertSessionsData(sessionsFromToday)
        } else {
            //Should be tested that the uncompleted session (session with only beginning, the current session) is the last and not the first
            val session = sessions.last()

            session.endSessionTime = timeFormatUtils.getTimeFromDateTime(dateTime)

            sessionsFromToday.session.removeAt(sessionsFromToday.session.lastIndex)
            sessionsFromToday.session.add(session)

            addSessionLevel(addTotalSessionTime(session))

            sessionsFromToday.totalDayTime = timeFormatUtils.calculateTotalTimeOfDay(sessionsFromToday.session)

            databaseManager.updateSession(session)
            databaseManager.updateSessionsData(sessionsFromToday)
        }
    }

    private fun addTotalSessionTime(session: Session): Session {
        session.totalSessionTime = timeFormatUtils.calculateTotalTimeOfSession(session.startSessionTime, session.endSessionTime)

        return session
    }

    private fun addSessionLevel(session: Session): Session {
        val totalTime = LocalTime.parse(session.totalSessionTime)
        val seconds = totalTime.toSecondOfDay()

        when {
            seconds < 300 -> session.sessionLevel = 0
            seconds in 301..599 -> session.sessionLevel = 1
            seconds in 601..1799 -> session.sessionLevel = 2
            seconds in 1801..3599 -> session.sessionLevel = 3
            seconds > 3600 -> session.sessionLevel = 4
            else -> session.sessionLevel = -1
        }

        return session
    }

    @SuppressLint("CheckResult")
    fun introduceTotalSessionTimeInDatabase() {
        databaseManager.getCompleteListOfSessionsFromToday()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { sessionsFromToday ->
                    updateSessionDataWithTotalSessionTime(sessionsFromToday)
                },
                { error ->
                    /*Add getview to have access to the view and show an error dialog */
                    System.out.println("Error in ReceiverPresenter EndSession: $error")
                })
    }

    private fun updateSessionDataWithTotalSessionTime(sessionsFromToday: SessionsData) {
        var index = 0

        for (session in sessionsFromToday.session) {
            if (session.totalSessionTime.isBlank()) {
                sessionsFromToday.session.removeAt(index)

                session.totalSessionTime =
                    timeFormatUtils.calculateTotalTimeOfSession(session.startSessionTime, session.endSessionTime)
                databaseManager.updateSession(session)
                sessionsFromToday.session.add(index, session)
                index++
            }
        }

        databaseManager.updateSessionsData(sessionsFromToday)
    }

    @SuppressLint("CheckResult")
    fun introduceTotalDaySessionTimeInDatabase() {
        databaseManager.getCompleteListOfSessionsFromToday()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { sessionsFromToday ->
                    updateTotalDayTimeInSessionData(sessionsFromToday)
                },
                { error ->
                    /*Add getview to have access to the view and show an error dialog */
                    System.out.println("Error in ReceiverPresenter EndSession: $error")
                })
    }

    private fun updateTotalDayTimeInSessionData(sessionsFromToday: SessionsData) {
        sessionsFromToday.totalDayTime = timeFormatUtils.calculateTotalTimeOfDay(sessionsFromToday.session)

        databaseManager.updateSessionsData(sessionsFromToday)
    }
}