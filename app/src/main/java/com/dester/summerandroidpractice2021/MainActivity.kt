package com.dester.summerandroidpractice2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dester.summerandroidpractice2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var counter = 0
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }


    fun init():Boolean{
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnJustButton.setOnClickListener {
            counter++
            binding.txvCounter.text = counter.toString()
        }
        return true
    }

}