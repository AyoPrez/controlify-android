package com.ayoprez.controlify

import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData

class DummyData {

    fun getSessionDataList(): MutableList<SessionsData> {

        val list = mutableListOf<SessionsData>()

        list.addAll(getJuneSessionData())
        list.addAll(getApril18SessionData())
        list.addAll(getAprilSessionData())
        list.addAll(getDecember18SessionData())
        list.addAll(getMaySessionData())

        return list
    }

    fun getSessionDataListWithEmptyElements(): MutableList<SessionsData> {

        val list = mutableListOf<SessionsData>()

        list.addAll(getJuneSessionData())
        list.addAll(mutableListOf())
        list.addAll(mutableListOf())
        list.addAll(mutableListOf())
        list.addAll(getAprilSessionData())
        list.addAll(getDecember18SessionData())
        list.addAll(mutableListOf())
        list.addAll(getMaySessionData())

        return list
    }

    fun getSessionDataListWithWrongFormattedDateElements(): MutableList<SessionsData> {

        val list = mutableListOf<SessionsData>()

        list.addAll(getJuneSessionData())
        list.addAll(getAprilWrongFormattedSessionData())
        list.addAll(getDecember18SessionData())
        list.addAll(getMaySessionData())

        return list
    }

    private fun getDecember18SessionData() : MutableList<SessionsData> {
        val sessionsDataDecember1 = SessionsData().apply {
            day = "01/12/2018"
            totalDayTime = "00:27:48"
        }

        val sessionDecember1_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember1_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        sessionsDataDecember1.sessions = arrayListOf(sessionDecember1_1, sessionDecember1_2)

        val sessionsDataDecember2 = SessionsData().apply {
            day = "03/12/2018"
            totalDayTime = "00:27:48"
        }

        val sessionDecember2_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        val sessionDecember2_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        val sessionDecember2_3 = Session().apply {
            startSessionTime = "09:28:40"
            endSessionTime = "09:35:13"
        }

        sessionsDataDecember2.sessions = arrayListOf(sessionDecember2_1, sessionDecember2_2, sessionDecember2_3)

        val sessionsDataDecember3 = SessionsData().apply {
            day = "07/12/2018"
            totalDayTime = "00:27:48"
        }
        val sessionDecember3_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember3_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember3_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember3_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember3_5 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataDecember3.sessions = arrayListOf(sessionDecember3_1, sessionDecember3_2, sessionDecember3_3, sessionDecember3_4, sessionDecember3_5)

        val sessionsDataDecember4 = SessionsData().apply {
            day = "19/12/2018"
            totalDayTime = "00:27:48"
        }
        val sessionDecember4_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember4_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember4_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionDecember4_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataDecember4.sessions = arrayListOf(sessionDecember4_1, sessionDecember4_2, sessionDecember4_3, sessionDecember4_4)

        return mutableListOf(sessionsDataDecember1, sessionsDataDecember2, sessionsDataDecember3, sessionsDataDecember4)
    }

    private fun getApril18SessionData() : MutableList<SessionsData> {
        val sessionsDataApril18_1 = SessionsData().apply {
            day = "01/04/2018"
            totalDayTime = "00:27:48"
        }
        val sessionApril181_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril181_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        sessionsDataApril18_1.sessions = arrayListOf(sessionApril181_1, sessionApril181_2)

        val sessionsDataApril18_2 = SessionsData().apply {
            day = "03/04/2018"
            totalDayTime = "00:27:48"
        }
        val sessionApril182_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril182_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }
        val sessionApril182_3 = Session().apply {
            startSessionTime = "09:28:40"
            endSessionTime = "09:35:13"
        }

        sessionsDataApril18_2.sessions = arrayListOf(sessionApril182_1, sessionApril182_2, sessionApril182_3)

        val sessionsDataApril18_3 = SessionsData().apply {
            day = "07/04/2018"
            totalDayTime = "00:27:48"
        }
        val sessionApril183_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril183_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril183_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril183_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril183_5 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataApril18_3.sessions = arrayListOf(sessionApril183_1, sessionApril183_2, sessionApril183_3, sessionApril183_4, sessionApril183_5)

        val sessionsDataApril18_4 = SessionsData().apply {
            day = "19/04/2018"
            totalDayTime = "00:27:48"
        }
        val sessionApril184_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril184_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril184_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril184_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataApril18_4.sessions = arrayListOf(sessionApril184_1, sessionApril184_2, sessionApril184_3, sessionApril184_4)

        return mutableListOf(sessionsDataApril18_1, sessionsDataApril18_2, sessionsDataApril18_3, sessionsDataApril18_4)
    }
    
    private fun getAprilSessionData() : MutableList<SessionsData> {
        val sessionsDataApril1 = SessionsData().apply {
            day = "01/04/2019"
            totalDayTime = "00:27:48"
        }
        val sessionApril1_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril1_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        sessionsDataApril1.sessions = arrayListOf(sessionApril1_1, sessionApril1_2)

        val sessionsDataApril2 = SessionsData().apply {
            day = "03/04/2019"
            totalDayTime = "00:27:48"
        }
        val sessionApril2_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril2_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }
        val sessionApril2_3 = Session().apply {
            startSessionTime = "09:28:40"
            endSessionTime = "09:35:13"
        }

        sessionsDataApril2.sessions = arrayListOf(sessionApril2_1, sessionApril2_2, sessionApril2_3)

        val sessionsDataApril3 = SessionsData().apply {
            day = "07/04/2019"
            totalDayTime = "00:27:48"
        }
        val sessionApril3_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril3_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril3_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril3_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril3_5 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataApril3.sessions = arrayListOf(sessionApril3_1, sessionApril3_2, sessionApril3_3, sessionApril3_4, sessionApril3_5)

        val sessionsDataApril4 = SessionsData().apply {
            day = "19/04/2019"
            totalDayTime = "00:27:48"
        }
        val sessionApril4_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril4_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril4_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionApril4_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataApril4.sessions = arrayListOf(sessionApril4_1, sessionApril4_2, sessionApril4_3, sessionApril4_4)

        return mutableListOf(sessionsDataApril1, sessionsDataApril2, sessionsDataApril3, sessionsDataApril4)
    }

    private fun getMaySessionData() : MutableList<SessionsData> {
        val sessionsDataMay1 = SessionsData().apply {
            day = "01/05/2019"
            totalDayTime = "00:27:48"
        }
        val sessionMay1_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay1_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        sessionsDataMay1.sessions = arrayListOf(sessionMay1_1, sessionMay1_2)

        val sessionsDataMay2 = SessionsData().apply {
            day = "03/05/2019"
            totalDayTime = "00:27:48"
        }
        val sessionMay2_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay2_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }
        val sessionMay2_3 = Session().apply {
            startSessionTime = "09:28:40"
            endSessionTime = "09:35:13"
        }

        sessionsDataMay2.sessions = arrayListOf(sessionMay2_1, sessionMay2_2, sessionMay2_3)

        val sessionsDataMay3 = SessionsData().apply {
            day = "07/05/2019"
            totalDayTime = "00:27:48"
        }
        val sessionMay3_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay3_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay3_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay3_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay3_5 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataMay3.sessions = arrayListOf(sessionMay3_1, sessionMay3_2, sessionMay3_3, sessionMay3_4, sessionMay3_5)

        val sessionsDataMay4 = SessionsData().apply {
            day = "19/05/2019"
            totalDayTime = "00:27:48"
        }
        val sessionMay4_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay4_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay4_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionMay4_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataMay4.sessions = arrayListOf(sessionMay4_1, sessionMay4_2, sessionMay4_3, sessionMay4_4)

        return mutableListOf(sessionsDataMay1, sessionsDataMay2, sessionsDataMay3, sessionsDataMay4)
    }
    
    private fun getJuneSessionData() : MutableList<SessionsData> {
        val sessionsDataJune1 = SessionsData().apply {
            day = "01/06/2019"
            totalDayTime = "00:27:48"
        }

        val sessionJune1_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune1_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        sessionsDataJune1.sessions = arrayListOf(sessionJune1_1, sessionJune1_2)

        val sessionsDataJune2 = SessionsData().apply {
            day = "03/06/2019"
            totalDayTime = "00:27:48"
        }

        val sessionJune2_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        val sessionJune2_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        val sessionJune2_3 = Session().apply {
            startSessionTime = "09:28:40"
            endSessionTime = "09:35:13"
        }

        sessionsDataJune2.sessions = arrayListOf(sessionJune2_1, sessionJune2_2, sessionJune2_3)

        val sessionsDataJune3 = SessionsData().apply {
            day = "07/06/2019"
            totalDayTime = "00:27:48"
        }
        val sessionJune3_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune3_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune3_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune3_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune3_5 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataJune3.sessions = arrayListOf(sessionJune3_1, sessionJune3_2, sessionJune3_3, sessionJune3_4, sessionJune3_5)

        val sessionsDataJune4 = SessionsData().apply {
            day = "19/06/2019"
            totalDayTime = "00:27:48"
        }
        val sessionJune4_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune4_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune4_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionJune4_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataJune4.sessions = arrayListOf(sessionJune4_1, sessionJune4_2, sessionJune4_3, sessionJune4_4)

        return mutableListOf(sessionsDataJune1, sessionsDataJune2, sessionsDataJune3, sessionsDataJune4)
    }

    private fun getAprilWrongFormattedSessionData() : MutableList<SessionsData> {
        val sessionsDataAprilWrongFormatted1 = SessionsData().apply {
            day = "1/04/2019"
            totalDayTime = "00:27:48"
        }
        val sessionAprilWrongFormatted1_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted1_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }

        sessionsDataAprilWrongFormatted1.sessions = arrayListOf(sessionAprilWrongFormatted1_1, sessionAprilWrongFormatted1_2)

        val sessionsDataAprilWrongFormatted2 = SessionsData().apply {
            day = "03/4/2019"
            totalDayTime = "00:27:48"
        }
        val sessionAprilWrongFormatted2_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted2_2 = Session().apply {
            startSessionTime = "08:18:20"
            endSessionTime = "08:20:45"
        }
        val sessionAprilWrongFormatted2_3 = Session().apply {
            startSessionTime = "09:28:40"
            endSessionTime = "09:35:13"
        }

        sessionsDataAprilWrongFormatted2.sessions = arrayListOf(sessionAprilWrongFormatted2_1, sessionAprilWrongFormatted2_2, sessionAprilWrongFormatted2_3)

        val sessionsDataAprilWrongFormatted3 = SessionsData().apply {
            day = "7/04/2019"
            totalDayTime = "00:27:48"
        }
        val sessionAprilWrongFormatted3_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted3_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted3_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted3_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted3_5 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataAprilWrongFormatted3.sessions = arrayListOf(sessionAprilWrongFormatted3_1, sessionAprilWrongFormatted3_2, sessionAprilWrongFormatted3_3, sessionAprilWrongFormatted3_4, sessionAprilWrongFormatted3_5)

        val sessionsDataAprilWrongFormatted4 = SessionsData().apply {
            day = "19/4/19"
            totalDayTime = "00:27:48"
        }
        val sessionAprilWrongFormatted4_1 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted4_2 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted4_3 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }
        val sessionAprilWrongFormatted4_4 = Session().apply {
            startSessionTime = "07:48:50"
            endSessionTime = "07:52:17"
        }

        sessionsDataAprilWrongFormatted4.sessions = arrayListOf(sessionAprilWrongFormatted4_1, sessionAprilWrongFormatted4_2, sessionAprilWrongFormatted4_3, sessionAprilWrongFormatted4_4)

        return mutableListOf(sessionsDataAprilWrongFormatted1, sessionsDataAprilWrongFormatted2, sessionsDataAprilWrongFormatted3, sessionsDataAprilWrongFormatted4)
    }
}