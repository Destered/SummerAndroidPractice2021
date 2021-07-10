package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil

class YearDiffUtilsCallback(
    var oldList:ArrayList<Year>,
    var newList:ArrayList<Year>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].yearName == newList[newItemPosition].yearName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].imageId == newList[newItemPosition].imageId
    }

}