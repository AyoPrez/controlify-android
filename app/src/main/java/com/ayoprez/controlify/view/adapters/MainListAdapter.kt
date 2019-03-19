package com.ayoprez.controlify.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayoprez.controlify.R
import com.ayoprez.controlify.model.SessionsData
import com.ayoprez.controlify.viewholder.MainListViewHolder
import kotlinx.android.synthetic.main.list_header.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import org.threeten.bp.ZoneOffset
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

class MainListAdapter : RecyclerView.Adapter<MainListViewHolder>() {

    var sessionData: MutableList<SessionsData>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MainListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sessionData?.size ?: 0
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {

        val dataSession = sessionData?.get(position)

        holder.bind(sessionData ?: mutableListOf())

        holder.itemView.header_day.text = formatDay(dataSession?.day ?: "")
        holder.itemView.header_total_time.text = holder.formatTotalTime(holder.itemView.context, dataSession?.totalDayTime ?: "")

        holder.itemView.header_layout.setOnClickListener {
            if (it?.id == R.id.header_layout) {
                if (holder.itemView.ll_child_items.visibility == View.VISIBLE) {
                    holder.itemView.ll_child_items.visibility = View.GONE
                } else {
                    holder.itemView.ll_child_items.visibility = View.VISIBLE
                }
            }
        }

        val numberOfChildrenInList = holder.itemView.ll_child_items.childCount
        val numberOfChildrenInArray = dataSession?.sessions?.size ?: 0

        if(numberOfChildrenInArray < numberOfChildrenInList) {
            for(index in numberOfChildrenInArray until numberOfChildrenInList){
                val child = holder.itemView.ll_child_items.getChildAt(index)
                child.visibility = View.GONE
            }
        }

        for (i in 0 until numberOfChildrenInArray) {
            val child = holder.itemView.ll_child_items.getChildAt(i)
            holder.setDataInChild(child, dataSession?.sessions?.get(i))
        }
    }

    private fun formatDay(day: String): String {
        if (day.isEmpty()) {
            return ""
        }

        val formatterIn = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneOffset.UTC)
        val date = formatterIn.parse(day)

        val formatterOut = DateTimeFormatter.ofPattern("EE dd MMM").withZone(ZoneOffset.UTC)
        return formatterOut.format(date)
    }
}