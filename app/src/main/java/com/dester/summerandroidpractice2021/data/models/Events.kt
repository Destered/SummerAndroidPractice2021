package com.dester.summerandroidpractice2021.data.models

data class Events(
    var years: MutableList<Year> = mutableListOf<Year>()
)
{
    fun addYear(year: Int){
        this.years.add(Year(null,year, mutableListOf<Mounth>(), null,null))
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
    }
}
