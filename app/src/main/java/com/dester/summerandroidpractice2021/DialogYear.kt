package com.dester.summerandroidpractice2021

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogYear : DialogFragment() {

    private val yearNames = arrayOf("2156", "34", "456")
    public var yearName = Int

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Choose a year")
                .setItems(yearNames
                ) { dialog, which ->
                    yearName
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}