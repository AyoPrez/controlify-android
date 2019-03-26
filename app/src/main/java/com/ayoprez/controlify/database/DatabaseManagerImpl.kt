package com.ayoprez.controlify.database

import com.ayoprez.controlify.FormatTimeUtils
import com.ayoprez.controlify.model.SessionsData
import com.orm.SugarRecord
import org.koin.core.KoinComponent
import org.koin.core.get
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime

class DatabaseManagerImpl : IDatabaseManager, KoinComponent {

    private val timeFormatTimeUtils: FormatTimeUtils = get()

    override fun getCompleteListOfSessions(): MutableList<SessionsData> {
        return SugarRecord.listAll(SessionsData::class.java)
    }

    override fun getLastSessionWithoutEnd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompleteListOfSessionsFromToday(): SessionsData {
        val todayDataSessions = SugarRecord.find(SessionsData::class.java, "day = ?", timeFormatTimeUtils.getDateFromDateTime(LocalDateTime.now()))


        return if (todayDataSessions.isEmpty()) {
            val sessionsData = SessionsData()
            sessionsData.day = timeFormatTimeUtils.getDateFromDateTime(LocalDateTime.now())

            sessionsData
        } else {
            todayDataSessions[0]
        }
    }

    override fun getCompleteListOfSessionsByDate(date: LocalDate): SessionsData {
        return SugarRecord.find(SessionsData::class.java, "day = ?", date.toString())[0]
    }

    override fun getLastCompleteListOfSessions(): SessionsData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateSessionsData(sessionsData: SessionsData) {
        sessionsData.save()
    }

}