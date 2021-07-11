package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.data.models.Mounth
import com.dester.summerandroidpractice2021.databinding.RecyclerMonthBinding
import java.time.Month
import java.util.ArrayList

class MonthAdapter(val openDayActivity:((Int) -> Unit)): RecyclerView.Adapter<MonthAdapter.MonthHolder>() {
    val monthList = ArrayList<Mounth>()
    inner class MonthHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding  = RecyclerMonthBinding.bind(item)
        fun bind(photoMonth: Mounth) = with(binding){
            ivRecycleMonth.setImageResource(photoMonth.imageId)
            tvRecycleMonth.text = photoMonth.tittle
            binding.root.setOnClickListener {
                openDayActivity.invoke(photoMonth.imageId)
            }
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

    fun addMonth(month: Mounth){
        monthList.add(month)
    }

    fun getList():ArrayList<Mounth>{
        val list:ArrayList<Mounth> = arrayListOf()
        monthList.forEach {
            list.add(it)
        }
        return list
    }

    fun setItems(newList: List<InfoMonth>){
        monthList.clear()
        monthList.addAll(newList)
    }

}