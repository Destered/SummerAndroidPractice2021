package com.dester.summerandroidpractice2021

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

     class CustomRecyclerAdapter (private val years: List<String>) :  RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var YearTextView: TextView? = null
        var YearImageView: ImageView? = null

        init {
            YearTextView = itemView.findViewById(R.id.tvear)
            YearImageView = itemView.findViewById(R.id.ivphotoear)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_photoyear, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.YearTextView?.text = years[position]
        holder.YearImageView?.setImageResource(R.drawable.test)
    }

    override fun getItemCount() = years.size
}