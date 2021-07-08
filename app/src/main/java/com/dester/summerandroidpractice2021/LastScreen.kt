package com.dester.summerandroidpractice2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dester.summerandroidpractice2021.databinding.ActivityLastScreenBinding

class LastScreen : AppCompatActivity() {

    private lateinit var binding:ActivityLastScreenBinding
    private lateinit var adapter: DayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastScreenBinding.inflate(layoutInflater)
        adapter = DayAdapter()
        binding.btnAdd.setOnClickListener {

        }
        setContentView(R.layout.activity_last_screen)
    }
}