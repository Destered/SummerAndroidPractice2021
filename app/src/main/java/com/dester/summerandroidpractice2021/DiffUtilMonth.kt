package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil
import com.dester.summerandroidpractice2021.data.models.Mounth

class DiffUtilMonth (
        var oldList:ArrayList<Mounth>,
        var newList:ArrayList<Mounth>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].mounthNumber== newList[newItemPosition].mounthNumber
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return (oldList[oldItemPosition].mounthId == newList[newItemPosition].mounthId && oldList[oldItemPosition].favoritePhoto == newList[newItemPosition].favoritePhoto)
        }
}