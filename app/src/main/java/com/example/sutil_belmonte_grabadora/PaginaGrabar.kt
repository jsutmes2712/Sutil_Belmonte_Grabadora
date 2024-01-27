package com.example.sutil_belmonte_grabadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class PaginaGrabar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_grabar)
        val botongrabar: Button = findViewById(R.id.botongrabar)

        botongrabar.setOnClickListener {
            grabarVideo(it)
        }
    }
    fun grabarVideo(view: View) {
        val REQUEST_VIDEO_CAPTURE = 1
        Intent(MediaStore.ACTION_VIDEO_CAPTURE).also { video ->
            video.resolveActivity(packageManager)?.also {
                startActivityForResult(video, REQUEST_VIDEO_CAPTURE)
            }
        }
    }
}