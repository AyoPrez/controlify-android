package com.ayoprez.controlify.presenter

import com.ayoprez.controlify.model.SessionsData
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.DateTimeParseException

class MainPresenter {

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

    fun sortSessionsInADay(){
        //Este método debe devolver las sesiones dentro de un día ordenados. Los primero serán los más tardes.
        //Se ordenarán siguiendo la primera de las dos horas. La hora en la que se encendió la pantalla.
        //Resultado del array:
        //1-17:45
        //2-17:33
        //3-12:09

    }

    //This should be done and tested. Maybe not here, but should be done and tested.
    fun calculateTotalTime(){
        //TODO
    }
}