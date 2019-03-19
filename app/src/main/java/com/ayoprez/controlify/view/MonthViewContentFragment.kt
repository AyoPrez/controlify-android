package com.ayoprez.controlify.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayoprez.controlify.R
import com.ayoprez.controlify.presenter.MainPresenter
import com.ayoprez.controlify.view.adapters.MainListAdapter
import kotlinx.android.synthetic.main.page_main.*
import org.koin.android.ext.android.inject

class MonthViewContentFragment : Fragment() {


    val presenter: MainPresenter by inject()

//    private val useData = arrayListOf<SessionsData>().apply {
//
//        val session = Session()
//
//        session.startSessionTime = "17:24:13"
//        session.endSessionTime = "17:33:30"
//        session.totalSessionTime = "00:09:17"
//        session.sessionLevel = 2
//
//        val sessionsData = SessionsData()
//
//        sessionsData.day = "22/01/2019"
//        sessionsData.totalDayTime = "00:27:54"
//        sessionsData.sessions = arrayListOf(session, session, session)
//
//
//        val session2 = Session()
//
//        session2.startSessionTime = "11:24:13"
//        session2.endSessionTime = "12:13:30"
//        session2.totalSessionTime = "00:49:17"
//        session2.sessionLevel = 4
//
//        val sessionsData2 = SessionsData()
//
//        sessionsData2.day = "02/02/2019"
//        sessionsData2.totalDayTime = "01:38:54"
//        sessionsData2.sessions = arrayListOf(session2, session2)
//
//
//        val session3 = Session()
//
//        session3.startSessionTime = "11:24:13"
//        session3.endSessionTime = "11:24:30"
//        session3.totalSessionTime = "00:00:17"
//        session3.sessionLevel = 0
//
//        val sessionsData3 = SessionsData()
//
//        sessionsData3.day = "24/01/2019"
//        sessionsData3.totalDayTime = "00:01:08"
//        sessionsData3.sessions = arrayListOf(session3, session3, session3, session3)
//
//
//        add(sessionsData)
//        add(sessionsData2)
//        add(sessionsData3)
//        add(sessionsData)
//
//        for (i in 0..100) {
//            add(sessionsData)
//            add(sessionsData2)
//            add(sessionsData3)
//        }
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listAdapter = MainListAdapter()

        recyclerview_main.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@MonthViewContentFragment.context, RecyclerView.VERTICAL, false)
            adapter = listAdapter
        }

        //listAdapter.sessionData = presenter
    }
}