package com.dester.summerandroidpractice2021


import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.checkSelfPermission
import com.dester.summerandroidpractice2021.data.models.Day
import com.dester.summerandroidpractice2021.data.models.Events
import com.dester.summerandroidpractice2021.data.models.Singleton
import com.dester.summerandroidpractice2021.data.models.Utils
import com.dester.summerandroidpractice2021.databinding.ActivityLastScreenBinding
import com.fondesa.kpermissions.allGranted
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.fondesa.kpermissions.extension.send


class LastScreen : AppCompatActivity() {

    private lateinit var bindingClass:ActivityLastScreenBinding
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
        bindingClass.btnBack.setOnClickListener{
            onClickBack()
        }
        bindingClass.btnAdd.setOnClickListener {
            check(this)
        }

    }
    fun init(){
        yearNumber = intent.getIntExtra("yearNumber", 0)
        monthNumber = intent.getIntExtra("monthNumber", 0)
        dayNumber = intent.getIntExtra("dayNumber", 0)
        val generalDay = database.years[yearNumber].mounths[monthNumber].days[dayNumber]
        generalDay.imageSourceView?.let { bindingClass.imgv2.setImageDrawable(Utils.stringToImage(it)) }


    }
    fun onRequest(){

        permissionsBuilder(Manifest.permission.CAMERA).build().send{
                result -> if (result.allGranted()){
                    openGallery()
                   }
            }
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val selectedImage = data?.getExtras()?.get("data") as Bitmap
                bindingClass.imgv2.setImageBitmap(selectedImage)

            }
        }
    }
    fun openGallery(){
        pickPhoto = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhoto, 1)

    }

fun check(context: Context){
    if (checkSelfPermission(context,Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED) {
        onRequest()

        return;

    }
    else{
        openGallery()
    }
}
    fun onClickBack(){
        this.finish()
    }
}