package com.dester.summerandroidpractice2021.data.database

import android.content.Context
import java.io.File
import com.google.gson.Gson
import com.dester.summerandroidpractice2021.data.models.Events
import com.dester.summerandroidpractice2021.data.models.Year
import java.util.*

class
Database(context: Context){

    private var file = File(context.filesDir.absolutePath + "database.json")

    init {
        if(!file.exists()) {
            file.createNewFile()
        }
    }
    fun add(item: Events){
        var gson = Gson()
        var jsonString = gson.toJson(item)
        file.writeText(jsonString)
    }

    fun getItems():Events{
        var inputString = file.bufferedReader().use {
            it.readText()
        }
        if(file.exists() && inputString.isNotEmpty()) {
            return Gson().fromJson(inputString, Events::class.java)
        }
        else{
            return Events(arrayListOf<Year>())
        }
    }

}