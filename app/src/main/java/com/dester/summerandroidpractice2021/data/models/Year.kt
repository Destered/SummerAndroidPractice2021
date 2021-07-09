package com.dester.summerandroidpractice2021.data.models

data class Year(
    var year: Int,
    var mounths: MutableList<Mounth>,
    var description: String?,

){
    var isFavorite: Boolean = false

    fun addMounth(mounth: Int, description: String?){
        this.mounths.add(Mounth(mounth, mutableListOf<Day>(), description))
    }
}
