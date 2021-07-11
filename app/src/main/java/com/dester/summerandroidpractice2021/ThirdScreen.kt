package com.dester.summerandroidpractice2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ThirdScreenBinding
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.util.*

class ThirdScreen : AppCompatActivity() {

    val listPhoto = arrayListOf<Day>(
        Day(R.drawable.photo_korzh,"1"),
        Day(R.drawable.moto_telka,"2"),
        Day(R.drawable.photo1,"3")
    )

    var index = 0
    lateinit var binding: ThirdScreenBinding
    private val adapter = DayAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcView.layoutManager = LinearLayoutManager(this@ThirdScreen)
        binding.rcView.adapter = adapter
        binding.btnAddDay.setOnClickListener {
            val newList = adapter.getList()

            if(index > 2) index = 0
            newList.add(listPhoto[index])
            index++

            val dayDiffUtilCallBack = DayDiffUtilCallBack(adapter.getList(), newList)
            val diffUtilsResult = DiffUtil.calculateDiff(dayDiffUtilCallBack)
            adapter.setDays(newList)
            diffUtilsResult.dispatchUpdatesTo(adapter)
        }
    }
}