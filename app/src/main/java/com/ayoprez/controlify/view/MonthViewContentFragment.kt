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

    private val presenter: MainPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listAdapter = MainListAdapter(presenter.getAllData())

        recyclerview_main.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@MonthViewContentFragment.context, RecyclerView.VERTICAL, false)
            adapter = listAdapter
        }
    }
}