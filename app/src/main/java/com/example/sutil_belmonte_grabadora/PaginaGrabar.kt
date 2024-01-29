package com.example.sutil_belmonte_grabadora

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class PaginaGrabar : AppCompatActivity() {

    val REQUEST_VIDEO_CAPTURE = 1
    private var videoUri: Uri? = null
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
            // Ahora puedes usar videoUri para acceder a la ubicación del video grabado
            // Por ejemplo, puedes mostrar la URL en un TextView o guardarla en una variable.
            // Si necesitas la ruta del archivo en el dispositivo, puedes usar videoUri?.path

            println(videoUri?.path)
        }
    }
}