package com.dester.summerandroidpractice2021.data.models

data class Events(
    var years: MutableList<Year> = mutableListOf<Year>()
)
{
    fun addYear(year: Int, description: String?){
        // Сделать проерку на существующие года
        this.years.add(Year(year, mutableListOf<Mounth>(), description))
    }
}
