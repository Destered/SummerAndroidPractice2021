package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.databinding.DayItemBinding

class DayAdapter: RecyclerView.Adapter<DayAdapter.DayHolder>() {
    private var dayList = ArrayList<Day>()

    class DayHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = DayItemBinding.bind(item)

        fun bind(day: Day){
            binding.photo.setImageResource(day.imageId)
            binding.description.text = day.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item,parent,false)
        return DayHolder(view)
    }

    override fun onBindViewHolder(holder: DayHolder, position: Int) {
        holder.bind(dayList[position])
    }

    override fun getItemCount(): Int {
        return dayList.size
    }

    fun addDay(day: Day){
        dayList.add(day)
    }

    fun getList(): ArrayList<Day>
    {
        val list: ArrayList<Day> = arrayListOf()
        dayList.forEach {
            list.add(it)
        }
        return list
    }

    fun setDays(list: ArrayList<Day>){
        dayList.clear()
        dayList.addAll(list)
    }
}