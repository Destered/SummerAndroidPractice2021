package com.dester.summerandroidpractice2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ActivityScreenSecondBinding
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.util.*
import kotlin.collections.ArrayList

class ScreenSecond : AppCompatActivity() {
    lateinit var binding: ActivityScreenSecondBinding
    private val adapter = MonthAdapter()
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
    private val monthNameList = listOf("january",
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun showMonthPicker() {
        val calendar: Calendar = Calendar.getInstance()
        val builder = MonthPickerDialog.Builder(
            this,
            object : MonthPickerDialog.OnDateSetListener {
                override fun onDateSet(selectedMonth: Int, selectedYear: Int) {
                    val newList: ArrayList<InfoMonth> = adapter.getList()
                    newList.add(InfoMonth(imageIdList[1], selectedMonth.toString(),monthNameList[selectedMonth]))
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


    private fun init() {
        binding.apply {
            rvphotoMonth.layoutManager = GridLayoutManager(this@ScreenSecond, 2)
            rvphotoMonth.adapter = adapter
            btnaddMonth.setOnClickListener {
                showMonthPicker()
            }
        }
    }
}