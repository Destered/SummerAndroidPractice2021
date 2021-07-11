package com.dester.summerandroidpractice2021.data.models

class EventDate (){
    lateinit var date: String
    var eventYear: Int? = null
    var eventMounth: Int? = null
    var eventDay: Int? = null

    constructor(year: Int, mounth: Int, day: Int):this(){
        eventYear = year
        eventMounth = mounth
        eventDay = day
    }
}