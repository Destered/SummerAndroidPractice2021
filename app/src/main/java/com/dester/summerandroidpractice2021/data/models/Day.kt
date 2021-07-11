package com.dester.summerandroidpractice2021.data.models

data class Day(
    var dayId: Int?,
    var description: String?,
    var imageSourceView: String?
){
    var isFavorite = false
}