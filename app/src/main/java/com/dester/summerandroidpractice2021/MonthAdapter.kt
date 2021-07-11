package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.data.models.Mounth
import com.dester.summerandroidpractice2021.data.models.Utils
import com.dester.summerandroidpractice2021.databinding.RecyclerMonthBinding
import java.util.ArrayList

class MonthAdapter(val openDayActivity:((Int) -> Unit),val favoriteMonth:((Int)->Unit)): RecyclerView.Adapter<MonthAdapter.MonthHolder>() {
    val monthList = ArrayList<Mounth>()
    inner class MonthHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding  = RecyclerMonthBinding.bind(item)
        fun bind(photoMonth: Mounth) = with(binding){
            photoMonth.favoritePhoto?.let {
                ivRecycleMonth.setImageDrawable(Utils.stringToImage(it))
            }
            if(photoMonth.isFavorite){

            }
            btnFavoriteMonth.setOnClickListener {
                favoriteMonth.invoke(photoMonth.mounthId ?: 0)
            }
            tvRecycleMonth.text = ScreenSecond.monthNameList[photoMonth.mounthNumber]
            root.setOnClickListener {
                openDayActivity.invoke(photoMonth.mounthId ?:0)
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

    fun setItems(newList: List<Mounth>){
        monthList.clear()
        monthList.addAll(newList)
    }
}