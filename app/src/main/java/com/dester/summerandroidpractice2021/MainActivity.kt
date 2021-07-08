package com.dester.summerandroidpractice2021


import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


public class MainActivity : AppCompatActivity() {
    var myYear = SimpleDateFormat("yyyy").format(Date()).toInt()
    lateinit var binding: ActivityMainBinding
    private val adapter = YearAdapter()
    private val imageIdList = listOf(R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4)
    private var index = 0
    private var yeartemp = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    fun init(){
        binding.apply {
            rvPhotoYear.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPhotoYear.adapter = adapter
            btnAddYear.setOnClickListener{
                val newList:ArrayList<Year> = adapter.getList()
                val dialog = DialogYear()
                if(index>3) index = 0
                newList.add(Year(imageIdList[index],dialog.yearName.toString()))
                val diffUtilsCallback = YearDiffUtilsCallback(adapter.getList(),newList)
                val resultDiffUtilsCallback = DiffUtil.calculateDiff(diffUtilsCallback)
                adapter.setItems(newList)
                resultDiffUtilsCallback.dispatchUpdatesTo(adapter)
                index++
                yeartemp++
            }
        }
    }
}