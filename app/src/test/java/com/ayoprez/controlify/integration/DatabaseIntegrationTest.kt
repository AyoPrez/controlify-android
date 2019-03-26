package com.ayoprez.controlify.integration

import com.ayoprez.controlify.DummyData
import com.ayoprez.controlify.database.IDatabaseManager
import com.ayoprez.controlify.presenter.ReceiverPresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner
import org.threeten.bp.LocalDateTime

@RunWith(MockitoJUnitRunner::class)
class DatabaseIntegrationTest {

    @Mock
    lateinit var databaseManager: IDatabaseManager

    private lateinit var receiverPresenter: ReceiverPresenter

    @Before
    fun setup(){
        receiverPresenter = ReceiverPresenter(databaseManager)
    }

    //Estoy testeando esto. Aún no está acabado. Falta un método, introduceEndSessionTimeInDatabase(). Además, debo probar los métodos ya testeados pero con datos corruptos
    //En plan, vacíos, con letras, incompletos, etc. Para ello he de terminar de corromper los dummy data del "DummyCorruptedData".
    // El objetivo es:
    // primero, que no crashee la app.
    // segundo, que no se note que algo ha salido mal. Poner número en sustitución de los que deberían estar

    @Test
    fun shouldUpdateTotalDaySessionsData(){

        val sessionsFromToday = DummyData().getSessionDataList()[0]

        Mockito.`when`(databaseManager.getCompleteListOfSessionsFromToday()).thenReturn(sessionsFromToday)

        receiverPresenter.introduceTotalDaySessionTimeInDatabase()

        sessionsFromToday.totalDayTime = receiverPresenter.calculateTotalTimeOfDay(sessionsFromToday.sessions)

        Mockito.verify(databaseManager, times(1)).updateSessionsData(sessionsFromToday)
    }

    @Test
    fun shouldUpdateTotalDaySessionsDataEvenWithEmptyFields(){

        val sessionsFromToday = DummyData().getSessionDataListWithEmptyElements()[0]

        Mockito.`when`(databaseManager.getCompleteListOfSessionsFromToday()).thenReturn(sessionsFromToday)

        receiverPresenter.introduceTotalDaySessionTimeInDatabase()

        sessionsFromToday.totalDayTime = receiverPresenter.calculateTotalTimeOfDay(sessionsFromToday.sessions)

        Mockito.verify(databaseManager, times(1)).updateSessionsData(sessionsFromToday)
    }

    @Test
    fun shouldUpdateTotalDaySessionsDataEvenWithWrongFormat(){

        val sessionsFromToday = DummyData().getSessionDataListWithWrongFormattedDateElements()[0]

        Mockito.`when`(databaseManager.getCompleteListOfSessionsFromToday()).thenReturn(sessionsFromToday)

        receiverPresenter.introduceTotalDaySessionTimeInDatabase()

        sessionsFromToday.totalDayTime = receiverPresenter.calculateTotalTimeOfDay(sessionsFromToday.sessions)

        Mockito.verify(databaseManager, times(1)).updateSessionsData(sessionsFromToday)
    }

    @Test
    fun shouldUploadTotalSessionData() {
        val sessionsFromToday = DummyData().getSessionDataList()[0]

        Mockito.`when`(databaseManager.getCompleteListOfSessionsFromToday()).thenReturn(sessionsFromToday)

        receiverPresenter.introduceTotalSessionTimeInDatabase()

        sessionsFromToday.sessions[0].totalSessionTime = receiverPresenter.calculateTotalTimeOfSession("07:48:50", "07:52:17")

        Mockito.verify(databaseManager, times(1)).updateSessionsData(sessionsFromToday)
    }

    @Test
    fun shouldUpdateWithNewSession(){
        val sessionsFromToday = DummyData().getSessionDataList()[0]

        Mockito.`when`(databaseManager.getCompleteListOfSessionsFromToday()).thenReturn(sessionsFromToday)

        receiverPresenter.introduceStartSessionTimeInDatabase(LocalDateTime.parse("2019-03-12T22:02:39.675"))

        sessionsFromToday.sessions[0].startSessionTime = receiverPresenter.getTimeFromDateTime(LocalDateTime.parse("2019-03-12T22:02:39.675"))

        Mockito.verify(databaseManager, times(1)).updateSessionsData(sessionsFromToday)
    }

    @Test
    fun shouldUpdateNewEndSession(){
        val sessionsFromToday = DummyData().getSessionDataList()[0]

        Mockito.`when`(databaseManager.getCompleteListOfSessionsFromToday()).thenReturn(sessionsFromToday)

        receiverPresenter.introduceEndSessionTimeInDatabase(LocalDateTime.parse("2019-03-12T22:02:39.675"))

        sessionsFromToday.sessions[0].endSessionTime = receiverPresenter.getTimeFromDateTime(LocalDateTime.parse("2019-03-12T22:02:39.675"))

        Mockito.verify(databaseManager, times(1)).updateSessionsData(sessionsFromToday)
    }

}