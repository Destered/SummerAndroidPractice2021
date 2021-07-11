package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil
import com.dester.summerandroidpractice2021.data.models.Day

class DayDiffUtilCallBack(val oldList:ArrayList<Day>, val newList:ArrayList<Day>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return  newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].dayId == newList[newItemPosition].dayId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].imageSourceView == newList[newItemPosition].imageSourceView
    }
}