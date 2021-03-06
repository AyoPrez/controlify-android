package com.ayoprez.controlify

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ayoprez.controlify.view.MonthViewContentFragment


//https://stackoverflow.com/questions/13218434/calendar-and-pageradapter-unlimited-views


class ViewPagerAdapter(fm: FragmentManager, private val fragmentList: MutableList<MonthViewContentFragment>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return 3
    }
}