package com.dester.summerandroidpractice2021.code_sample

import androidx.recyclerview.widget.DiffUtil
import com.dester.summerandroidpractice2021.code_sample.model.Info

class InfoListDiffUtilsCallback(
        var oldList:ArrayList<Info>,
        var newList:ArrayList<Info>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].description == newList[newItemPosition].description
    }

}