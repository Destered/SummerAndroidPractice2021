package com.dester.summerandroidpractice2021


import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.checkSelfPermission
import com.dester.summerandroidpractice2021.data.models.Day
import com.dester.summerandroidpractice2021.data.models.Events
import com.dester.summerandroidpractice2021.data.models.Singleton
import com.dester.summerandroidpractice2021.data.models.Utils
import com.dester.summerandroidpractice2021.databinding.ActivityLastScreenBinding
import com.kotlinpermissions.KotlinPermissions


class LastScreen : AppCompatActivity() {

    private lateinit var bindingClass: ActivityLastScreenBinding
    private lateinit var dayInfo: Day
    private lateinit var pickPhoto: Intent
    lateinit var database: Events
    var yearNumber = 0
    var monthNumber = 0
    var dayNumber = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Singleton.getInstance(this)
        bindingClass = ActivityLastScreenBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        init()
        bindingClass.bSaveText.setOnClickListener{
            database.years[yearNumber].mounths[monthNumber].days[dayNumber].description = bindingClass.inputText.text.toString()
        }
        bindingClass.btnBack.setOnClickListener {
            onClickBack()
        }
        bindingClass.btnAdd.setOnClickListener {
            Log.d("click", "click")
            check(this)
        }

    }

    fun init() {
        yearNumber = intent.getIntExtra("yearNumber", 0)
        monthNumber = intent.getIntExtra("monthNumber", 0)
        dayNumber = intent.getIntExtra("dayNumber", 0)
        dayInfo = database.years[yearNumber].mounths[monthNumber].days[dayNumber]
        dayInfo.imageSourceView?.let { bindingClass.imgv2.setImageDrawable(Utils.stringToImage(it)) }
        bindingClass.inputText.setText(dayInfo.description ?:"")

    }

    fun onRequest() {
        KotlinPermissions.with(this)
            .permissions(Manifest.permission.READ_EXTERNAL_STORAGE)
            .onAccepted { permissions ->
                openGallery()
            }
            .onDenied { permissions ->
                Toast.makeText(applicationContext,"Необходимы права для доступа",Toast.LENGTH_SHORT).show()
            }
            .onForeverDenied { permissions ->
                Toast.makeText(applicationContext,"Выдайте права через настройки приложения",Toast.LENGTH_SHORT).show()
            }
            .ask()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val selectedImageUri = data?.data
                selectedImageUri?.let{
                    val image = MediaStore.Images.Media.getBitmap(applicationContext.contentResolver,
                        Uri.parse(it.toString()))
                    bindingClass.imgv2.setImageBitmap(image)
                    database.years[yearNumber].mounths[monthNumber].days[dayNumber].imageSourceView = Utils.imageToString(
                        BitmapDrawable(resources, image)
                    )
                    Singleton.saveData(this)
                }
            }
        }
    }

    fun openGallery() {
        pickPhoto = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhoto, 1)
    }

    fun check(context: Context) {
        if (checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            onRequest()
        } else {
            openGallery()
        }
    }

    fun onClickBack() {
        this.finish()
    }

}