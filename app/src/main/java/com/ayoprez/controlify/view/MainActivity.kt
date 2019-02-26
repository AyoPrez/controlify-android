package com.ayoprez.controlify.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerTabStrip
import androidx.viewpager.widget.ViewPager
import com.ayoprez.controlify.R
import com.ayoprez.controlify.UpdateService
import com.ayoprez.controlify.ViewPagerAdapter
import com.ayoprez.controlify.model.SessionsData
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainActivityView {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: ViewPagerAdapter
    private lateinit var pagerStripTitle: PagerTabStrip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textview_toolbar_main.apply {
            text = getString(R.string.app_name)
        }

        val intent = Intent(this, UpdateService::class.java)
        startService(intent)

        setupViewPager()
    }

    fun setupViewPager(){

        pagerStripTitle = pager_tab_strip
        pagerStripTitle.setTabIndicatorColorResource(R.color.white)

        val fragList = arrayListOf<MonthViewContentFragment>().toMutableList()
        fragList.add(MonthViewContentFragment())
        fragList.add(MonthViewContentFragment())
        fragList.add(MonthViewContentFragment())

        //There will be always only 3 fragments, but every time the user change the fragment, all three are upgrade with the right info


        viewPager = pager
        pagerAdapter = ViewPagerAdapter(supportFragmentManager, fragList)
        viewPager.adapter = pagerAdapter
        pager.setCurrentItem(2, false)

        //pager.addOnPageChangeListener(this)
    }

    override fun informationForCurrentPager(dataList: MutableList<SessionsData>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun informationForLastPager(dataList: MutableList<SessionsData>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
