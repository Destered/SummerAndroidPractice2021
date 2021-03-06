package com.dester.summerandroidpractice2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.dester.summerandroidpractice2021.data.models.Events
import com.dester.summerandroidpractice2021.data.models.Mounth
import com.dester.summerandroidpractice2021.data.models.Singleton
import com.dester.summerandroidpractice2021.data.models.Utils
import com.dester.summerandroidpractice2021.databinding.ActivityScreenSecondBinding
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.util.*
import kotlin.collections.ArrayList

class ScreenSecond : AppCompatActivity() {
    lateinit var binding: ActivityScreenSecondBinding
    lateinit var database: Events
    var yearNumber = 0
    private val adapter = MonthAdapter ({ number -> openDayActivity(number) },{number ->favoriteMonth(number)})
    companion object {
        val monthNameList = listOf(
            "январь",
            "февраль",
            "март",
            "апрель",
            "май",
            "июнь",
            "июль",
            "август",
            "сентябрь",
            "октябрь",
            "ноябрь",
            "декабрь"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenSecondBinding.inflate(layoutInflater)
        database = Singleton.getInstance(this)
        yearNumber = intent.getIntExtra("yearNumber",0)
        setContentView(binding.root)
        init()
    }
    fun showMonthPicker() {
        val calendar: Calendar = Calendar.getInstance()
        val builder = MonthPickerDialog.Builder(
            this,

            object : MonthPickerDialog.OnDateSetListener {
                override fun onDateSet(selectedMonth: Int, selectedYear: Int) {
                    if(database.monthSelectedList.contains(selectedMonth)){
                        Toast.makeText(this@ScreenSecond, "Этот месяц уже существует",Toast.LENGTH_SHORT).show()
                    }
                    else {
                        database.years[yearNumber].addMounth(this@ScreenSecond, selectedMonth)
                        database.monthSelectedList.add(selectedMonth)
                        val newList: ArrayList<Mounth> = database.years[yearNumber].mounths
                        val diffUtilsCallback = DiffUtilMonth(adapter.getList(), newList)
                        val resultDiffUtilsCallback = DiffUtil.calculateDiff(diffUtilsCallback)
                        adapter.setItems(newList)
                        resultDiffUtilsCallback.dispatchUpdatesTo(adapter)
                    }
                }

            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH)
        )


        builder.setMinYear(2000)
            .setMaxYear(calendar.get(Calendar.YEAR))
            .showMonthOnly()
            .build()
            .show()
    }
    fun openDayActivity(monthNumber:Int){
        val intent = Intent(this,ThirdScreen::class.java)
        intent.putExtra("monthNumber", monthNumber)
        intent.putExtra("yearNumber", yearNumber)
        startActivity(intent)
    }
    private fun init() {
        adapter.setItems(database.years[yearNumber].mounths)
        binding.apply {
            rvphotoMonth.layoutManager = GridLayoutManager(this@ScreenSecond, 2)
            rvphotoMonth.adapter = adapter
            btnaddMonth.setOnClickListener {
                showMonthPicker()
            }
            btnBackmonth.setOnClickListener {
                this@ScreenSecond.finish()
            }
            tvYear.text = database.years[yearNumber].yearNumber.toString()

        }
    }

    fun favoriteMonth(monthNumber: Int) {
        val month = database.years[yearNumber].mounths[monthNumber]
        if(month.favoritePhoto==null){
            Toast.makeText(applicationContext,"Нужно выбрать изображение",Toast.LENGTH_SHORT).show()
        }
        else{
            binding.ivEmptyFrame.setImageDrawable(Utils.stringToImage( month.favoritePhoto ?:""))
            database.years[yearNumber].mounths.forEach{
                it.isFavorite = false
            }
            month.isFavorite = true
            database.years[yearNumber].favoritePhoto = month.favoritePhoto
        }
    }
    override fun onResume() {
        super.onResume()
        val newList: ArrayList<Mounth> = database.years[yearNumber].mounths
        adapter.setItems(newList)
        adapter.notifyDataSetChanged()
    }

    override fun onPause() {
        Singleton.saveData(this)
        super.onPause()
    }
}