package com.dester.summerandroidpractice2021.code_sample.model

data class Info(
        var name:String,
        var description:String
){
    override fun toString(): String {
        return "Info(name='$name', description='$description')"
    }
}
