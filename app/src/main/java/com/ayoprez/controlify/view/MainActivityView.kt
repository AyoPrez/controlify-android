package com.ayoprez.controlify.view

import com.ayoprez.controlify.model.SessionsData

interface MainActivityView {

    fun informationForCurrentPager(dataList: MutableList<SessionsData>)
    fun informationForLastPager(dataList: MutableList<SessionsData>)

}