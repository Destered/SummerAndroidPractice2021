package com.dester.summerandroidpractice2021.data.models

import com.dester.summerandroidpractice2021.data.database.Database
import androidx.fragment.app.Fragment

object Singleton {
    lateinit var events: Events

    init {
        events = Database(Fragment().requireContext()).getItems()
    }
}