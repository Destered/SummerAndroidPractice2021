package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil

class DayDiffUtilCallBack(val oldList:ArrayList<Day>, val newList:ArrayList<Day>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return  newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].imageId == newList[newItemPosition].imageId

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].desc == newList[newItemPosition].desc
    }
}