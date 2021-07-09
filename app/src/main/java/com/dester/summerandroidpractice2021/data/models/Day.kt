package com.dester.summerandroidpractice2021.data.models

import androidx.core.widget.TintableImageSourceView
import java.text.DateFormat
import java.util.Date

data class Day(
    var date: EventDate,
    var title: String,
    var description: String?,
    var imageSourceView: String?

){
    var isFavorite = false
}