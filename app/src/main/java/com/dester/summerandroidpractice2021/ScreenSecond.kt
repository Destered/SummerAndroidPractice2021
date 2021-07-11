package com.dester.summerandroidpractice2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.data.models.Events
import com.dester.summerandroidpractice2021.data.models.Mounth
import com.dester.summerandroidpractice2021.data.models.Singleton
import com.dester.summerandroidpractice2021.databinding.ActivityScreenSecondBinding
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.util.*
import kotlin.collections.ArrayList

class ScreenSecond : AppCompatActivity() {
    lateinit var binding: ActivityScreenSecondBinding
    lateinit var database: Events
    var yearNumber = 0
    private val adapter = MonthAdapter ({ number -> openDayActivity(number) })
    private val imageIdList = listOf(R.drawable.january,
        R.drawable.february,
        R.drawable.mart,
        R.drawable.april,
        R.drawable.may,
        R.drawable.june,
        R.drawable.jule,
        R.drawable.august,
        R.drawable.september,
        R.drawable.october,
        R.drawable.november,
        R.drawable.december
    )
    companion object {
        val monthNameList = listOf(
            "january",
            "february",
            "march",
            "april",
            "may",
            "june",
            "jule",
            "august",
            "september",
            "october",
            "november",
            "december"
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
                    database.years[yearNumber].addMounth(selectedMonth)
                    val newList: ArrayList<Mounth> = database.years[yearNumber].mounths
                    val diffUtilsCallback = DiffUtilMonth(adapter.getList(), newList)
                    val resultDiffUtilsCallback = DiffUtil.calculateDiff(diffUtilsCallback)
                    adapter.setItems(newList)
                    resultDiffUtilsCallback.dispatchUpdatesTo(adapter)
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
        }

    }
}