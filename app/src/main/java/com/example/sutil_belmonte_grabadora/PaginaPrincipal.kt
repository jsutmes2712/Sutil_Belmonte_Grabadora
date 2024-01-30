package com.example.sutil_belmonte_grabadora

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.sutil_belmonte_grabadora.data.VideoDB

class PaginaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 123)
        }
        //Pedimos permisos
        if (
            (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED) ||
            (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED) ||
            (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_MEDIA_VIDEO
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_MEDIA_VIDEO
                ),
                123
            )
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Damos funcionalidad a las opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Grabar -> {
                val intentGrabar = Intent(this, PaginaGrabar::class.java)
                startActivity(intentGrabar)
                return true
            }
            R.id.Reproducir -> {
                val intentGrabar = Intent(this, PaginaReproducir::class.java)
                startActivity(intentGrabar)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}