package com.dester.summerandroidpractice2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.data.models.Day
import com.dester.summerandroidpractice2021.data.models.Events
import com.dester.summerandroidpractice2021.data.models.Singleton
import com.dester.summerandroidpractice2021.data.models.Year
import com.dester.summerandroidpractice2021.databinding.ThirdScreenBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class ThirdScreen : AppCompatActivity() {

    lateinit var database: Events
    var monthNumber = 0
    var yearNumber = 0
    lateinit var binding: ThirdScreenBinding
    private val adapter = DayAdapter({ number -> openFourthActivity(number) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Singleton.getInstance(this)
        monthNumber = intent.getIntExtra("monthNumber", 0)
        yearNumber = intent.getIntExtra("yearNumber", 0)
        binding = ThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        adapter.setDays(database.years[yearNumber].mounths[monthNumber].days)

        binding.rcView.layoutManager = LinearLayoutManager(this@ThirdScreen)
        binding.rcView.adapter = adapter

        binding.btnBack.setOnClickListener {
            this.finish()
        }

        binding.btnAddDay.setOnClickListener() {
            onDataSet()
        }
    }

    fun onDataSet(){

        database.years[yearNumber].mounths[monthNumber].addDay()
        val newList: ArrayList<Day> = database.years[yearNumber].mounths[monthNumber].days
        val dayDiffUtilCallBack = DayDiffUtilCallBack(adapter.getList(), newList)
        val diffUtilResult = DiffUtil.calculateDiff(dayDiffUtilCallBack)
        adapter.setDays(newList)
        diffUtilResult.dispatchUpdatesTo(adapter)
    }

    fun openFourthActivity(dayNumber: Int){
        val intent = Intent(this,ThirdScreen::class.java)
        intent.putExtra("dayNumber", dayNumber)
        intent.putExtra("monthNumber", monthNumber)
        intent.putExtra("yearNumber", yearNumber)
        startActivity(intent)
    }
}