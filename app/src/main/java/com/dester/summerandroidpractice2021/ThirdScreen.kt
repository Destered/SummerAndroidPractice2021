package com.dester.summerandroidpractice2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ThirdScreenBinding

class ThirdScreen : AppCompatActivity() {
    lateinit var binding: ThirdScreenBinding
    private val adapter = DayAdapter()
    var index:Int = 0
    val list: ArrayList<Day> = arrayListOf(
        Day(R.drawable.photo_korzh, "AAA"),
        Day(R.drawable.photo1,"BBB"),
        Day(R.drawable.moto_telka,"CCC")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@ThirdScreen)
            rcView.adapter = adapter
            btnAddDay.setOnClickListener {
                val newList = adapter.getList()
                if(index > 2) index = 0
                newList.add(list[index])
                index++
                val dayDiffUtilCallBack = DayDiffUtilCallBack(adapter.getList(), newList)
                val callBackResult = DiffUtil.calculateDiff(dayDiffUtilCallBack)
                adapter.setDays(newList)
                callBackResult.dispatchUpdatesTo(adapter)
            }
        }
    }
}