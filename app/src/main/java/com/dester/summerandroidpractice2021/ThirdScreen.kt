package com.dester.summerandroidpractice2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.data.models.*
import com.dester.summerandroidpractice2021.databinding.ThirdScreenBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.properties.Delegates

class ThirdScreen : AppCompatActivity() {

    lateinit var database: Events
    var monthNumber = 0
    var yearNumber = 0
    lateinit var binding: ThirdScreenBinding
    private val adapter = DayAdapter({ number -> openFourthActivity(number) }, { number -> favoriteButton(number) })

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
        database.years[yearNumber].mounths[monthNumber].favoritePhoto?.let{
            binding.placeUnderImageMonth.setImageDrawable(Utils.stringToImage(it))
        }
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

        database.years[yearNumber].mounths[monthNumber].addDay(this)
        val newList: ArrayList<Day> = database.years[yearNumber].mounths[monthNumber].days
        val dayDiffUtilCallBack = DayDiffUtilCallBack(adapter.getList(), newList)
        val diffUtilResult = DiffUtil.calculateDiff(dayDiffUtilCallBack)
        adapter.setDays(newList)
        diffUtilResult.dispatchUpdatesTo(adapter)
    }

    fun favoriteButton(dayNumber: Int){
        val day = database.years[yearNumber].mounths[monthNumber].days[dayNumber]
        if(day.imageSourceView == null){
            Toast.makeText(applicationContext, "Нужно выбрать изображение", Toast.LENGTH_SHORT).show()
        }
        else {
            binding.placeUnderImageMonth.setImageDrawable(Utils.stringToImage(day.imageSourceView ?: ""))
            database.years[yearNumber].mounths[monthNumber].days.forEach {
                it.isFavorite = false
            }
            day.isFavorite = true
            database.years[yearNumber].mounths[monthNumber].favoritePhoto = day.imageSourceView
        }
    }

    fun openFourthActivity(dayNumber: Int){
        val intent = Intent(this,LastScreen::class.java)
        intent.putExtra("dayNumber", dayNumber)
        intent.putExtra("monthNumber", monthNumber)
        intent.putExtra("yearNumber", yearNumber)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val newList: ArrayList<Day> = database.years[yearNumber].mounths[monthNumber].days
        adapter.setItems(newList)
        adapter.notifyDataSetChanged()

    }

    override fun onPause() {
        Singleton.saveData(this)
        super.onPause()
    }
}