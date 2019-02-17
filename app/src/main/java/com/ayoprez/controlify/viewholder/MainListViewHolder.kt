package com.ayoprez.controlify.viewholder

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayoprez.controlify.R
import com.ayoprez.controlify.model.Session
import com.ayoprez.controlify.model.SessionsData
import kotlinx.android.synthetic.main.list_content.view.*
import kotlinx.android.synthetic.main.list_item.view.*



class MainListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(sessionsData: MutableList<SessionsData>){

        var intMaxNumberOfChildren = 0
        for (index in 0 until sessionsData.size) {
            val intMaxSizeTemp = sessionsData[index].sessions.size
            if (intMaxSizeTemp > intMaxNumberOfChildren) intMaxNumberOfChildren = intMaxSizeTemp
        }

        itemView.ll_child_items.removeAllViews()

        for (index in 0 until intMaxNumberOfChildren) {
            val contentView = LayoutInflater.from(itemView.context).inflate(R.layout.list_content, itemView.ll_child_items, false)

            itemView.ll_child_items.addView(contentView)
        }
    }

    fun setDataInChild(contentView: View, session: Session?): View {

        contentView.content_item_image.setImageResource(getImageFromSessionLevel(session?.sessionLevel ?: -1))
        contentView.content_item_time.setText(setColorsInSessionTime(contentView.context, session), TextView.BufferType.SPANNABLE)
        contentView.content_item_total_time.text = formatTotalTime(contentView.context, session?.totalSessionTime ?: "")

        return contentView
    }

    private fun setColorsInSessionTime(context: Context, session: Session?): Spannable {

        val sessionTime = String.format(context.getString(R.string.session_time), session?.startSessionTime ?: "",
            session?.endSessionTime ?: "")

        val spannable = SpannableString(sessionTime)

        spannable.setSpan(ForegroundColorSpan(context.resources.getColor(R.color.darkGreen)), 0, sessionTime.indexOf('-'), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannable.setSpan(ForegroundColorSpan(Color.RED), sessionTime.indexOf('-') + 1, sessionTime.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        return spannable
    }

    private fun getImageFromSessionLevel(level: Int): Int{

        return when(level) {
            0 -> R.drawable.ic_eyes
            1 -> R.drawable.ic_happy
            2 -> R.drawable.ic_phone
            3 -> R.drawable.ic_hand_stop
            4 -> R.drawable.ic_warning
            5 -> R.drawable.ic_tv
            else -> R.drawable.ic_unknown
        }
    }

    fun formatTotalTime(context: Context, totalTime: String): String{

        if (totalTime.isEmpty()) {
            return ""
        }

        var totalTimeFormatted = ""

        val totalTimeArray = totalTime.split(":")

        if (totalTimeArray.size == 3) {
            val hours = totalTimeArray[0]
            val minutes = totalTimeArray[1]
            val seconds = totalTimeArray[2]

            totalTimeFormatted = if (hours == "00") {
                String.format(context.getString(R.string.day_total_time_no_hours), minutes, seconds)
            } else if (hours == "00" && minutes == "00") {
                String.format(context.getString(R.string.day_total_time_only_seconds), seconds)
            } else {
                String.format(context.getString(R.string.day_total_time), hours, minutes, seconds)
            }

        } else if (totalTimeArray.size == 2) {
            val minutes = totalTimeArray[0]
            val seconds = totalTimeArray[1]

            totalTimeFormatted = if (minutes == "00") {
                String.format(context.getString(R.string.day_total_time_only_seconds), seconds)
            } else {
                String.format(context.getString(R.string.day_total_time_no_hours), minutes, seconds)
            }
        } else if (totalTimeArray.size == 1) {
            val seconds = totalTimeArray[0]

            totalTimeFormatted = String.format(context.getString(R.string.day_total_time_only_seconds), seconds)
        }

        return totalTimeFormatted
    }
}