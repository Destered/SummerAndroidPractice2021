package com.dester.summerandroidpractice2021.data.models

import android.graphics.drawable.Drawable

data class Mounth(
    var mounthId: Int?,
    var mounthNumber: Int,
    var days: ArrayList<Day>,
    var description: String?,
    var favoritePhoto: String?
){
    var isFavorite: Boolean = false

    fun addDay(date: EventDate, title: String, description: String?, imageString: String?){
        this.days.add(Day(date, title, description, imageString, days.size))
    }
}
