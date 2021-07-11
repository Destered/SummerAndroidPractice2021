package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil

class DayDiffUtilCallBack(val oldList:ArrayList<com.dester.summerandroidpractice2021.data.models.Day>, val newList:ArrayList<com.dester.summerandroidpractice2021.data.models.Day>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return  newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].description == newList[newItemPosition].description
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}