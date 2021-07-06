package com.dester.summerandroidpractice2021.code_sample

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.R
import com.dester.summerandroidpractice2021.code_sample.model.Info


class MainActivity : AppCompatActivity() {


    lateinit var adapter: NewCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val year: RecyclerView =  findViewById(R.id.rv_photoYear)
        val button: ImageButton = findViewById(R.id.btn_addYear)
        button.setOnClickListener {
            val newList = adapter.getList()
            newList.add(Info("${(Math.random()*10)+1.toInt()}","${(Math.random()*10)+1.toInt()}"))
            val infoListDiffUtilsCallback = InfoListDiffUtilsCallback(adapter.getList(),newList)
            val callbackResult = DiffUtil.calculateDiff(infoListDiffUtilsCallback)
            adapter.setItems(newList)
            callbackResult.dispatchUpdatesTo(adapter)
            Log.d("NewList","${adapter.getList().toString()}")
        }
        adapter = NewCustomAdapter()
        adapter.setItems(arrayListOf(
                Info("A","B"),
                Info("New","Old"),
                Info("First","Second")
        ))

        year.adapter = adapter
    }


}