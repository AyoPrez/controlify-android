package com.ayoprez.controlify.database

import com.ayoprez.controlify.model.SessionsData

class DatabaseManagerImpl : IDatabaseManager {

    override fun getLastSessionWithoutEnd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompleteListOfSessionsFromToday(): SessionsData {
        return SessionsData()
    }

    override fun getCompleteListOfSessionsByDate(): SessionsData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLastCompleteListOfSessions(): SessionsData {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateSessionsData(sessionsData: SessionsData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}