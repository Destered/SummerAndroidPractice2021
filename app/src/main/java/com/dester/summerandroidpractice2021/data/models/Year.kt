package com.dester.summerandroidpractice2021.data.models

data class Year(
    var yearId: Int?,
    var yearNumber: Int,
    var mounths: ArrayList<Mounth>,
    var description: String?,
    var favoritePhoto: String?

){
    var isFavorite: Boolean = false

    fun addMounth(mounth: Int){
        this.mounths.add(Mounth(null,mounth, arrayListOf(), 0,null, null))
        Events.sortMonth(mounths)
    }
}
