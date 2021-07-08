package com.dester.summerandroidpractice2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ActivityScreenSecondBinding

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
    private var count= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rvphotoMonth.layoutManager = GridLayoutManager(this@ScreenSecond, 2)
            rvphotoMonth.adapter = adapter
            btnaddMonth.setOnClickListener {
                if(count>11) count = 0
                val month = InfoMonth(imageIdList[count], monthNameList[count])
                adapter.addMonth(month)
                count++
            }
        }
    }
}