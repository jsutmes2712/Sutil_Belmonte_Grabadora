package com.example.sutil_belmonte_grabadora

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.example.sutil_belmonte_grabadora.data.Video
import com.example.sutil_belmonte_grabadora.data.VideoAPP
import kotlinx.coroutines.launch

class PaginaGrabar : AppCompatActivity() {

    val REQUEST_VIDEO_CAPTURE = 1
    private var videoUri: Uri? = null
    private val app = VideoAPP
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_grabar)
        val botongrabar: Button = findViewById(R.id.botongrabar)

        botongrabar.setOnClickListener {
            grabarVideo(it)
        }
    }
    fun grabarVideo(view: View) {

        Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { video ->
            video.resolveActivity(packageManager)?.also {
                startActivityForResult(video, REQUEST_VIDEO_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            // Video grabado con éxito
            videoUri = data?.data

            var path = handleMediaStoreUri(context = applicationContext, uri = videoUri!!)


            lifecycleScope.launch {
                val list = app.room.VideoDAO().insertVideo(Video(nombre = "pruebame esta", url = path!!))
            }

            println(handleMediaStoreUri(context = applicationContext, uri = videoUri!!))
        }
    }

    private fun handleMediaStoreUri(context: Context, uri: Uri): String? {
        // Manejar URI basada en MediaStore
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = context.contentResolver.query(uri, projection, null, null, null)

        cursor?.use {
            val columnIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            it.moveToFirst()
            return it.getString(columnIndex)
        }

        return null
    }

}