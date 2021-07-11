package com.dester.summerandroidpractice2021.data.models

import android.graphics.drawable.Drawable

data class Mounth(
    var mounthId: Int?,
    var mounthNumber: Int,
    var days: ArrayList<Day>,
    var countDays: Int,
    var description: String?,
    var favoritePhoto: String?
){
    var isFavorite: Boolean = false

    fun addDay(){
        this.days.add(Day(null,null, null))
        Events.sortDay(days)
    }
}
