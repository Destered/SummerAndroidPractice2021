package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.data.models.Utils
import com.dester.summerandroidpractice2021.data.models.Year
import com.dester.summerandroidpractice2021.databinding.RvPhotoyearBinding
import java.util.ArrayList

class YearAdapter(
    val openMonthActivity:((Int) -> Unit)
):RecyclerView.Adapter<YearAdapter.YearHolder>() {
    val yearList = ArrayList<Year>()

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

    fun getList():ArrayList<Year>{
        val list:ArrayList<Year> = arrayListOf()
        yearList.forEach {
            list.add(it)
        }
        return list
    }

    fun setItems(listYear: List<Year>){
        yearList.clear()
        yearList.addAll(listYear)
    }

    fun addYear(year: Year){
        yearList.add(year)
    }

    inner class YearHolder(item: View):RecyclerView.ViewHolder(item) {
        val binding = RvPhotoyearBinding.bind(item)
        fun bind(year: Year)=with(binding){
            year?.favoritePhoto?.let { ivEmptyfrane.setImageDrawable(Utils.stringToImage(it)) }

            tvYear.text=year.yearNumber.toString()
            binding.root.setOnClickListener {
                openMonthActivity.invoke(year.yearId ?: 0)
            }
        }
    }
}