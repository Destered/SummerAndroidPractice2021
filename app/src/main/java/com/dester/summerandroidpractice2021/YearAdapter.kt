package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.databinding.RvPhotoyearBinding
import java.util.ArrayList

class YearAdapter:RecyclerView.Adapter<YearAdapter.YearHolder>() {
    val yearList=ArrayList<Year>()
    class YearHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = RvPhotoyearBinding.bind(item)
        fun bind(year: Year)=with(binding){
            ivEmptyfrane.setImageResource(year.imageId)
            tvYear.text=year.yearname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YearHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_photoyear,parent,false)
        return YearHolder(view)
    }


    override fun onBindViewHolder(holder: YearHolder, position: Int) {
        holder.bind(yearList[position])
    }

    override fun getItemCount(): Int {
        return yearList.size
    }

    fun addYear(year: Year){
        yearList.add(year)
        notifyDataSetChanged()
    }
}