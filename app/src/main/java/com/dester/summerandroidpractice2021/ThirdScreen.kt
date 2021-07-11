package com.dester.summerandroidpractice2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ThirdScreenBinding
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.util.*

class ThirdScreen : AppCompatActivity() {

    lateinit var binding: ThirdScreenBinding
    private val adapter = DayAdapter({ number -> openFourthActivity(number) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcView.layoutManager = LinearLayoutManager(this@ThirdScreen)
        binding.rcView.adapter = adapter
        binding.btnBack.setOnClickListener {
            this.finish()
        }
        binding.btnAddDay.setOnClickListener {
            val newList = adapter.getList()



            val dayDiffUtilCallBack = DayDiffUtilCallBack(adapter.getList(), newList)
            val diffUtilsResult = DiffUtil.calculateDiff(dayDiffUtilCallBack)
            adapter.setDays(newList)
            diffUtilsResult.dispatchUpdatesTo(adapter)
        }
    }

    fun openFourthActivity(dayNumber: Int){
//        val intent = Intent(this,ThirdScreen::class.java)
//        intent.putExtra("yearNumber",dayNumber)
//        startActivity(intent)
    }
}