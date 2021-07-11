package com.dester.summerandroidpractice2021

import androidx.recyclerview.widget.DiffUtil

class DiffUtilMonth (
        var oldList:ArrayList<InfoMonth>,
        var newList:ArrayList<InfoMonth>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].monthName== newList[newItemPosition].monthName
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].imageId == newList[newItemPosition].imageId
        }
}