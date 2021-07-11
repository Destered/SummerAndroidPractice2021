package com.dester.summerandroidpractice2021.data.models

data class Year(
    var yearId: Int?,
    var yearNumber: Int,
    var mounths: MutableList<Mounth>,
    var description: String?,
    var favoritePhoto: String?

){
    var isFavorite: Boolean = false

    fun addMounth(mounth: Int, description: String?):Mounth{
        val mounth = Mounth(mounth, mutableListOf<Day>(), description)
        this.mounths.add(mounth)

        return mounth
    }
}
