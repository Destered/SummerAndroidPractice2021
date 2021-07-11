package com.dester.summerandroidpractice2021.data.models

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.util.Base64
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable
import java.io.ByteArrayOutputStream

class Utils{
        companion object {
            fun imageToString(image: Drawable): String {
                var bitmap = image.toBitmap()
                val byteStram = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteStram)
                val byteArray = byteStram.toByteArray()
                val baseString = Base64.encodeToString(byteArray, Base64.DEFAULT)
                return baseString

            }

            fun stringToImage(imageString: String): Drawable {
                val decodeByte = Base64.decode(imageString, Base64.DEFAULT)
                val decodeImage = BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.size)
                return decodeImage.toDrawable(Resources.getSystem())
            }
        }
}