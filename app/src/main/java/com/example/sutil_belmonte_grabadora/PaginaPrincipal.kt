package com.example.sutil_belmonte_grabadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class PaginaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)
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