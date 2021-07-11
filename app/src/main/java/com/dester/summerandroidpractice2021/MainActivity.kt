package com.dester.summerandroidpractice2021


import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ActivityMainBinding
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    var myYear = SimpleDateFormat("yyyy").format(Date()).toInt()
    lateinit var binding: ActivityMainBinding
    private val adapter = YearAdapter()
    private val imageIdList = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4
    )
    private var index = 0
    private var yeartemp = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun showYearPicker() {
        val calendar: Calendar = Calendar.getInstance()
        val builder = MonthPickerDialog.Builder(
            this,
            object : MonthPickerDialog.OnDateSetListener {
                override fun onDateSet(selectedMonth: Int, selectedYear: Int) {
                    val newList: ArrayList<Year> = adapter.getList()
                    newList.add(Year(imageIdList[index], selectedYear.toString()))
                    val diffUtilsCallback = YearDiffUtilsCallback(adapter.getList(), newList)
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
            .showYearOnly()
            .build()
            .show()
    }

    fun init() {
        binding.apply {
            rvPhotoYear.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPhotoYear.adapter = adapter
            btnAddYear.setOnClickListener {
                showYearPicker()
            }
        }
    }
}