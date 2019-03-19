package com.ayoprez.controlify.presenter

import com.ayoprez.controlify.DummyData
import org.junit.Assert
import org.junit.Test

class MainPresenterTest {

    private val presenter = MainPresenter()

    //region Months

    @Test
    fun shouldGetMonthDataSeparated(){

        val list = presenter.distributeDataByMonth(DummyData().getSessionDataList())

        //A list of months that has inside a list of session data

        val firstEntryMonth = list.last().first().day.substring(3, list.last().first().day.lastIndexOf('/'))

        val lastEntryMonth = list.last().last().day.substring(3, list.last().last().day.lastIndexOf('/'))

        //In the same list(same month), the last element of the list should be in the same month than the first
        Assert.assertEquals(firstEntryMonth, lastEntryMonth)
    }

    @Test
    fun shouldGet5ListsOfMonths(){
        val list = presenter.distributeDataByMonth(DummyData().getSessionDataList())
        Assert.assertEquals(5, list.count())
    }

    @Test
    fun shouldReturnEmptyMonthListIfListIsEmpty(){
        val list = presenter.distributeDataByMonth(mutableListOf())

        Assert.assertTrue(list.isEmpty())
    }

    @Test
    fun shouldNotHaveEmptyElementsInMonthsList(){
        val list = presenter.distributeDataByMonth(DummyData().getSessionDataListWithEmptyElements())

        var hasEmptyElement = false

        for (data in list) {
            if (data.isEmpty()) {
                hasEmptyElement = true
            }
        }

        Assert.assertFalse(hasEmptyElement)
    }

    @Test
    fun shouldNotFailWhenHasWrongFormat(){
        val list = presenter.distributeDataByMonth(DummyData().getSessionDataListWithWrongFormattedDateElements())

        val firstEntryMonth = list.last().first().day.substring(3, list.last().first().day.lastIndexOf('/'))

        val lastEntryMonth = list.last().last().day.substring(3, list.last().last().day.lastIndexOf('/'))

        //In the same list(same month), the last element of the list should be in the same month than the first
        Assert.assertEquals(firstEntryMonth, lastEntryMonth)
    }

    @Test
    fun shouldBeSortedAscendancy(){
        val list = presenter.distributeDataByMonth(DummyData().getSessionDataList())

        val firstMonth = list.first().first().day.substring(3, list.first().first().day.lastIndexOf('/')).toInt()

        val secondMonth = list[1].first().day.substring(3, list[1].first().day.lastIndexOf('/')).toInt()

        val thirdMonth = list[2].first().day.substring(3, list[2].first().day.lastIndexOf('/')).toInt()

        val isGreater:Boolean = secondMonth in (thirdMonth + 1)..(firstMonth - 1)

        Assert.assertTrue(isGreater)
    }

    //endregion

    //region Years

    @Test
    fun shouldGetOnlyLastYearData(){

        val list = presenter.distributeDataByYear(DummyData().getSessionDataList())

        //A list of months that has inside a list of session data

        val firstEntryMonth = list.last().first().first().day.substring(3, list.last().first().first().day.lastIndexOf('/'))

        val lastEntryMonth = list.last().first().last().day.substring(3, list.last().first().last().day.lastIndexOf('/'))

        //In the same list(same month), the last element of the list should be in the same month than the first
        Assert.assertEquals(firstEntryMonth, lastEntryMonth)
    }

    @Test
    fun shouldGet2ListsOfYears(){
        val list = presenter.distributeDataByYear(DummyData().getSessionDataList())

        Assert.assertEquals(2, list.count())
    }

    @Test
    fun shouldReturnEmptyYearsListIfListIsEmpty(){
        val list = presenter.distributeDataByYear(mutableListOf())

        Assert.assertTrue(list.isEmpty())
    }

    //endregion

    @Test
    fun shouldReturnTheSessionsOFADaySorted(){
        val list = presenter.sortSessionsInADay(DummyData().getSessionDataList())

        val firstSession = list[2].sessions.first().startSessionTime
        val lastSession = list[2].sessions.last().startSessionTime

        val isGreater: Boolean = firstSession > lastSession

        Assert.assertTrue(isGreater)
    }

    @Test
    fun shouldReturnTheSessionsSortedAfterSortTheMonths(){
        val list = presenter.distributeDataByMonth(presenter.sortSessionsInADay(DummyData().getSessionDataList()))

        val firstSession = list[0][0].sessions.first().startSessionTime
        val lastSession = list[0][0].sessions.last().startSessionTime

        val isGreater: Boolean = firstSession > lastSession

        Assert.assertTrue(isGreater)
    }

    @Test
    fun shouldGetThatIsTheSameYear(){
        val list = DummyData().getSessionDataList()

        val isSameYear = presenter.isCurrentYear(list[0].day)

        Assert.assertTrue(isSameYear)
    }

}
