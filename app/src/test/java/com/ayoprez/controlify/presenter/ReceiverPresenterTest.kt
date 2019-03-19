package com.ayoprez.controlify.presenter

import com.ayoprez.controlify.DummyData
import com.ayoprez.controlify.database.IDatabaseManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.threeten.bp.LocalDateTime


@RunWith(MockitoJUnitRunner::class)
class ReceiverPresenterTest {


    @Mock
    lateinit var databaseManager: IDatabaseManager

    private lateinit var presenter:ReceiverPresenter

    @Before
    fun setup(){
        presenter = ReceiverPresenter(databaseManager)
    }

    @Test
    fun shouldGetDateFromDateTime(){
        val timeParsed = LocalDateTime.parse("2019-03-12T17:04:28.550")
        val result = "12/03/2019"

        val date = presenter.getDateFromDateTime(timeParsed)

        Assert.assertEquals(result, date)
    }

    @Test
    fun shouldGetTimeFromDateTime() {
        val timeParsed = LocalDateTime.parse("2019-03-12T17:04:28.550")
        val result = "17:04:28"

        val date = presenter.getTimeFromDateTime(timeParsed)

        Assert.assertEquals(result, date)
    }

    @Test
    fun shouldCalculateTheTotalTimeOfASession(){
        val sessionStart = DummyData().getSessionDataList().first().sessions.first().startSessionTime
        val sessionEnd = DummyData().getSessionDataList().first().sessions.first().endSessionTime

        val totalTime = presenter.calculateTotalTimeOfSession(sessionStart, sessionEnd)

        val result = DummyData().getSessionDataList().first().sessions.first().totalSessionTime

        Assert.assertEquals(result, totalTime)
    }

    @Test
    fun shouldCalculateTotalTimeOfTheDay(){
        val totalTime = presenter.calculateTotalTimeOfDay(DummyData().getSessionDataList().first().sessions)

        val result = DummyData().getSessionDataList().first().totalDayTime

        Assert.assertEquals(result, totalTime)
    }
}