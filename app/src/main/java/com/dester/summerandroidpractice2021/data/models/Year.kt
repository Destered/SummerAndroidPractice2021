package com.dester.summerandroidpractice2021.data.models

import android.content.Context

data class Year(
    var yearId: Int?,
    var yearNumber: Int,
    var mounths: ArrayList<Mounth>,
    var description: String?,
    var favoritePhoto: String?

){
    var isFavorite: Boolean = false

    fun addMounth(context: Context,mounth: Int){
        this.mounths.add(Mounth(null,mounth, arrayListOf(), 0,null, null))
        Events.sortMonth(mounths)
        /*Singleton.saveData(context)*/
    }
}
