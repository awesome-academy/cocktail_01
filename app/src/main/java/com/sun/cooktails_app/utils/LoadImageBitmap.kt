@file:Suppress("DEPRECATION")

package com.sun.cooktails_app.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.URL

@Suppress("DEPRECATION")
class LoadImageBitmap( val imageView: ImageView) :
    AsyncTask<String?, Void?, Bitmap?>() {
    override fun doInBackground(vararg params: String?): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val url = URL(params[0])
            val inputStream = url.openConnection().getInputStream()
            bitmap = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    override fun onPostExecute(result: Bitmap?) {
        imageView.setImageBitmap(result)
    }
}
