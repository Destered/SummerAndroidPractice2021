package com.dester.summerandroidpractice2021.data.models

import android.content.Context
import com.dester.summerandroidpractice2021.data.database.Database
import androidx.fragment.app.Fragment

class Singleton {

    companion object {

        @Volatile private var INSTANCE: Events? = null

        fun getInstance(context: Context): Events =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Database(context).getItems()
    }
}