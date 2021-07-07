package com.dester.summerandroidpractice2021

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ActivityMainBinding


public class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private val adapter = YearAdapter()
    private val imageIdList = listOf(R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4)
    private var index =0
    private var yeartemp= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()


    }

    public  fun init(){
        binding.apply {
            rvPhotoYear.layoutManager=LinearLayoutManager(this@MainActivity)
            rvPhotoYear.adapter = adapter
            btnAddYear.setOnClickListener{
                if(index>3) index = 0
                val year = Year(imageIdList[index],(2021-yeartemp).toString())
                adapter.addYear(year)
                index++
                yeartemp++
            }
        }
    }
}