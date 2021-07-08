package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.databinding.CardDayBinding

class DayAdapter: RecyclerView.Adapter<DayAdapter.DayHolder>() {
    val dayList = ArrayList<DayInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_day,parent,false)
        return DayHolder(view)
    }

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        holder.bind(dayList[position])
    }

    override fun getItemCount(): Int {
        return dayList.size
    }

    fun getList():ArrayList<DayInfo>{
        val list:ArrayList<DayInfo> = arrayListOf()
        dayList.forEach {
            list.add(it)
        }
        return list
    }

    fun setItems(listDayInfo: List<DayInfo>){
        dayList.clear()
        dayList.addAll(listDayInfo)
    }

    fun addDayInfo(DayInfo: DayInfo){
        dayList.add(DayInfo)
    }

    inner class DayHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = CardDayBinding.bind(item)
        fun bind(dayInfo: DayInfo)= with(binding){
            dayImage.setImageBitmap(dayInfo.dayImage)
        }
    }
}