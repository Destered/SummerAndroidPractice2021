package com.dester.summerandroidpractice2021



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dester.summerandroidpractice2021.data.models.Events
import com.dester.summerandroidpractice2021.data.models.Singleton
import com.dester.summerandroidpractice2021.data.models.Year
import com.dester.summerandroidpractice2021.databinding.ActivityMainBinding
import com.whiteelephant.monthpicker.MonthPickerDialog
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var database: Events
    private val adapter = YearAdapter ({ number -> openMonthActivity(number) })

    private val imageIdList = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        R.drawable.photo4
    )
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Singleton.getInstance(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun showYearPicker() {
        val calendar: Calendar = Calendar.getInstance()
        val builder = MonthPickerDialog.Builder(
            this,
            { _, selectedYear ->
                database.addYear(selectedYear)
                val newList: ArrayList<Year> = database.years
                val diffUtilsCallback = YearDiffUtilsCallback(adapter.getList(), newList)
                val resultDiffUtilsCallback = DiffUtil.calculateDiff(diffUtilsCallback)
                adapter.setItems(newList)
                resultDiffUtilsCallback.dispatchUpdatesTo(adapter)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH)
        )
        builder.setMinYear(2000)
            .setMaxYear(calendar.get(Calendar.YEAR))
            .showYearOnly()
            .build()
            .show()
    }

    fun openMonthActivity(yearNumber:Int){
        val intent = Intent(this,ScreenSecond::class.java)
        intent.putExtra("yearNumber",yearNumber)
        startActivity(intent)
    }

    fun init() {
        adapter.setItems(database.years)
        binding.apply {
            rvPhotoYear.layoutManager = LinearLayoutManager(this@MainActivity)
            rvPhotoYear.adapter = adapter
            btnAddYear.setOnClickListener {
                showYearPicker()
            }
        }
    }

    override fun onPause() {
        Singleton.saveData(this)
        super.onPause()
    }
}