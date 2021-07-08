package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.databinding.RecyclerMonthBinding
import java.util.ArrayList

class MonthAdapter: RecyclerView.Adapter<MonthAdapter.MonthHolder>() {
    val monthList = ArrayList<InfoMonth>()
    class MonthHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding  = RecyclerMonthBinding.bind(item)
        fun bind(photoMonth: InfoMonth) = with(binding){
            ivRecycleMonth.setImageResource(photoMonth.imageId)
            rvRecycleMonth.text = photoMonth.tittle

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_month, parent, false)
        return MonthHolder(view)
    }

    override fun onBindViewHolder(holder: MonthHolder, position: Int) {
        holder.bind(monthList[position])
    }

    override fun getItemCount(): Int {
        return monthList.size
    }

    fun addMonth(month: InfoMonth){
        monthList.add(month)
    }
}