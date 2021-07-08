package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil

class DayDiffUtilsCallback(
    var oldList:ArrayList<DayInfo>,
    var newList:ArrayList<DayInfo>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].dayImage == newList[newItemPosition].dayImage
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }


}