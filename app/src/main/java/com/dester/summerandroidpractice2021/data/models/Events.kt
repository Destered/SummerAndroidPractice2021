package com.dester.summerandroidpractice2021.data.models

data class Events(
    var years: MutableList<Year> = mutableListOf<Year>()
)
{
    fun addYear(year: Int, description: String?){
        this.years.add(Year(year, mutableListOf<Mounth>(), description))
    }

    fun sort(){
        this.years.sortBy { it.year }
        this.years.forEach{
            it.mounths.sortBy { it.mounth }
        }
        this.years.forEach{
            it.mounths.forEach{
                it.days.sortBy { it.date.eventDay }
            }
        }
    }
}
