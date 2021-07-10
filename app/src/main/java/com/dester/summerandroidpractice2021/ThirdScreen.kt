package com.dester.summerandroidpractice2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ThirdScreenBinding

class ThirdScreen : AppCompatActivity() {
    lateinit var binding: ThirdScreenBinding
    private val adapter = DayAdapter()
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
                val a = Day(R.drawable.moto_telka, "Description Day")
                adapter.addDay(a)
            }
        }
    }
}