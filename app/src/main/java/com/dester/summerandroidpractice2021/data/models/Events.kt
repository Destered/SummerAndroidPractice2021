package com.dester.summerandroidpractice2021.data.models

data class Events(
    var years: ArrayList<Year> = arrayListOf<Year>()
)
{
    fun addYear(year: Int){
        this.years.add(Year(null,year, arrayListOf<Mounth>(), null,null))
        sortYear(years)
    }

    companion object {
        fun sortYear(listYear: MutableList<Year>): List<Year> {
            listYear.sortBy {
                it.yearNumber
            }
            var counter = 0
            listYear.forEach {
                it.yearId = counter
                counter++
            }
            return listYear
        }

        fun sortMonth(listMounth: ArrayList<Mounth>): List<Mounth>{
            listMounth.sortBy {
                it.mounthNumber
            }
            var counter = 0
            listMounth.forEach{
                it.mounthId = counter
                counter++
            }
            return listMounth
        }

        fun sortDay(listDay: ArrayList<Day>): List<Day>{
            var counter =0
            listDay.forEach {
                it.dayId = counter
                counter++
            }
            return listDay
        }
    }
}
