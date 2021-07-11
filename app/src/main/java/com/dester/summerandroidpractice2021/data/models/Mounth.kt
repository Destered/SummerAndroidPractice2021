package com.dester.summerandroidpractice2021.data.models

import android.graphics.drawable.Drawable

data class Mounth(
    var mounth: Int?,
    var days: MutableList<Day>,
    var description: String?,
){
    var isFavorite: Boolean = false

    fun addDay(date: EventDate, title: String, description: String?, imageString: String?){
        this.days.add(Day(date, title, description, imageString, days.size))
    }
}
