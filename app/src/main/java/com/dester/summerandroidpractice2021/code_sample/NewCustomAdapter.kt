package com.dester.summerandroidpractice2021.code_sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dester.summerandroidpractice2021.databinding.RecyclerviewPhotoyearBinding
import com.dester.summerandroidpractice2021.code_sample.model.Info
import java.util.ArrayList

class NewCustomAdapter() : RecyclerView.Adapter<NewCustomAdapter.VH>() {

    private val items: ArrayList<Info> = arrayListOf()

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Info>) {
        this.items.clear()
        this.items.addAll(items)
    }

    fun getList():ArrayList<Info>{
        val list:ArrayList<Info> = arrayListOf()
        items.forEach {
            list.add(it)
        }
        return list
    }

    fun addItem(item: Info) {
        this.items.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerviewPhotoyearBinding.inflate(layoutInflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position, items[position])
    }


    inner class VH(private val binding: RecyclerviewPhotoyearBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, info: Info) {
            binding.tvear.text = info.name
            binding.description.text = info.description
        }
    }
}