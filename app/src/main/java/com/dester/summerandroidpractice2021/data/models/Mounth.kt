package com.dester.summerandroidpractice2021.data.models

data class Mounth(
    var mounth: Int,
    var days: MutableList<Day>,
    var description: String?,
){
    var isFavorite: Boolean = false

    fun addDay(date: EventDate, title: String, description: String?){
        this.days.add(Day(date, title, description))
    }
}
