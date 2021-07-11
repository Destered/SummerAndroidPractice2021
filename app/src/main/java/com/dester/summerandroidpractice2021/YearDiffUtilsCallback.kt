package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil
import com.dester.summerandroidpractice2021.data.models.Year

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
        return oldList[oldItemPosition].yearNumber == newList[newItemPosition].yearNumber
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].yearId == newList[newItemPosition].yearId && oldList[oldItemPosition].favoritePhoto==newList[newItemPosition].favoritePhoto)
    }

}