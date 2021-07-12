package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.data.models.Day
import com.dester.summerandroidpractice2021.data.models.Utils
import com.dester.summerandroidpractice2021.databinding.DayItemBinding

class DayAdapter(
    val openFourthActivity:((Int) -> Unit),
    val favoriteButton:((Int) -> Unit)
): RecyclerView.Adapter<DayAdapter.DayHolder>() {
    var dayList = ArrayList<Day>()

    inner class DayHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = DayItemBinding.bind(item)
        fun bind(day: Day){
                day.imageSourceView?.let {
                    binding.photo.setImageDrawable(Utils.stringToImage(it))
                }
                if(day.isFavorite) {
                    binding.btnStar.setImageResource(android.R.drawable.btn_star_big_on)
                }
                binding.btnStar.setOnClickListener {
                    favoriteButton.invoke(day.dayId ?: 0)
                }
                binding.photo.setOnClickListener {
                    openFourthActivity.invoke(day.dayId ?: 0)
                }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false)
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
        notifyDataSetChanged()
    }

    fun getList(): ArrayList<Day>
    {
        val list = ArrayList<Day>()
        dayList.forEach {
            list.add(it)
        }
        return list
    }

    fun setItems(newList: ArrayList<Day>){
        dayList.clear()
        dayList.addAll(newList)
    }

    fun setDays(list: ArrayList<Day>){
        dayList.clear()
        dayList.addAll(list)
    }
}