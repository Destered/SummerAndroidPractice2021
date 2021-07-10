package com.dester.summerandroidpractice2021

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.dester.summerandroidpractice2021.databinding.ActivityLastScreenBinding


class LastScreen : AppCompatActivity() {

    lateinit var bindingClass:ActivityLastScreenBinding
    private lateinit var adapter: DayAdapter
    private lateinit var button: Button
    private final val selectPicture = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityLastScreenBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val img = bindingClass.rvImage.Recycler()
        adapter = DayAdapter()
        bindingClass.btnAdd.setOnClickListener {
           val i: Intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), selectPicture)
        }

    }
    public fun onActivityResult (int requestCode, int resultCode, Intent data){
        if(requestCode == resultOk){
            if(requestCode == selectPicture) {
                Uri selectedImageUri = data.getData()
                 val selectedImagePath = getPath(selectedImageUri)
                bindingClass.rvImage.Recycler() = selecteedImagePath
                img.setImageURI(selectedImageUri)
            }
            }
        }
    public fun getPath(uri: Uri){

    }
    }
}