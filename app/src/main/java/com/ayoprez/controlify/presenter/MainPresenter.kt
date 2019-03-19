package com.ayoprez.controlify.presenter

import com.ayoprez.controlify.model.SessionsData
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.DateTimeParseException

class MainPresenter {

    fun isCurrentYear(date: String): Boolean { //With this method I can say in the UI if show or not the year after the month's name in the title of the viewpager
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")).year == LocalDate.now().year
    }

    fun distributeDataByMonth(dataList: MutableList<SessionsData>) : MutableList<MutableList<SessionsData>> {

        val dateTimeStrToLocalDateTime: (SessionsData) -> LocalDate = {
            try {
                LocalDate.parse(it.day, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            } catch (error: DateTimeParseException) {

                if (it.day.substring(0, it.day.indexOf('/')).length == 1) {
                    LocalDate.parse(it.day, DateTimeFormatter.ofPattern("d/MM/yyyy"))
                } else if (it.day.substring(3, it.day.lastIndexOf('/')).length == 1 && it.day.substring(it.day.lastIndexOf('/') + 1, it.day.length).length == 4) {
                    LocalDate.parse(it.day, DateTimeFormatter.ofPattern("dd/M/yyyy"))
                } else if (it.day.substring(3, it.day.lastIndexOf('/')).length == 1 && it.day.substring(it.day.lastIndexOf('/') + 1, it.day.length).length == 2) {
                    LocalDate.parse(it.day, DateTimeFormatter.ofPattern("dd/M/yy"))
                } else if (it.day.substring(it.day.lastIndexOf('/') + 1, it.day.length).length == 2) {
                    LocalDate.parse(it.day, DateTimeFormatter.ofPattern("dd/MM/yy"))
                } else {
                    LocalDate.parse(it.day, DateTimeFormatter.ofPattern("dd/M/yy"))
                }
            }
        }


        //This method should sort by month and year so the result should be 1- June, 2 - May, 3- April, 4- Dec 2018 5- April 2018

        return dataList
            .asSequence()
            .sortedByDescending(dateTimeStrToLocalDateTime)
            .groupBy { it.day.substring(3, it.day.count()) }
            .map { it.value.toMutableList() }
            .toMutableList()
    }

    fun distributeDataByYear(dataList: MutableList<SessionsData>) : MutableList<MutableList<MutableList<SessionsData>>> {
        return dataList
            .asSequence()
            .sortedWith(compareBy { it.day })
            .groupBy { it.day.substring(3, it.day.lastIndexOf('/')) }
            .map { it.value.toMutableList() }
            .groupBy { it.first().day.substring(it.first().day.lastIndexOf('/'), it.first().day.length) }
            .map { it.value.toMutableList() }
            .toMutableList()
    }

    fun sortSessionsInADay(dataList: MutableList<SessionsData>): MutableList<SessionsData> {
        val sessionsList: MutableList<SessionsData> = mutableListOf()

        for (data in dataList) {
            val sortedData = data.sessions
                .sortedByDescending { it.startSessionTime }

            data.sessions.clear()
            data.sessions.addAll(sortedData)

            sessionsList.add(data)
        }
        return sessionsList
    }
}