package com.ayoprez.controlify.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayoprez.controlify.R
import com.ayoprez.controlify.model.SessionsData
import com.ayoprez.controlify.presenter.MainPresenter
import com.ayoprez.controlify.view.adapters.MainListAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.page_main.*
import org.koin.android.ext.android.inject

class MonthViewContentFragment : Fragment() {

    private val presenter: MainPresenter by inject()

    override fun onResume() {
        super.onResume()

        loadAllData(view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_main, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadAllData(view)
    }



    private fun setupRecyclerView(sessionsDataList: MutableList<SessionsData>) {
        val listAdapter = MainListAdapter(sessionsDataList)

        //FIXME: Change this. Don't setup again the whole recyclerview every time

        recyclerview_main.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this@MonthViewContentFragment.context, RecyclerView.VERTICAL, false)
            adapter = listAdapter
        }
    }

    @SuppressLint("CheckResult")
    private fun loadAllData(view: View?) {
        presenter.getAllData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { success -> setupRecyclerView(success) },
                { error ->
                    if (view != null) {
                        showError(view.context, error)
                    }
                })
    }

    private fun showError(context: Context, error: Throwable) {
        AlertDialog.Builder(context)
            .setTitle(R.string.error_title)
            .setMessage(R.string.error_getting_data_local_database)
            .setPositiveButton(R.string.error_ok_button) { dialog, _ -> dialog.dismiss() }
            .create().show()

        System.out.println("Error: $error")
    }
}