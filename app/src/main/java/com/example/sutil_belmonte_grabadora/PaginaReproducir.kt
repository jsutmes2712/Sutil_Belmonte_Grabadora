package com.example.sutil_belmonte_grabadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sutil_belmonte_grabadora.data.Video
import com.example.sutil_belmonte_grabadora.data.VideoAPP
import com.example.sutil_belmonte_grabadora.recycler.VideoAdapter
import kotlinx.coroutines.launch

class PaginaReproducir : AppCompatActivity() {

    private lateinit var isbnEditText: EditText
    private lateinit var botonBuscar: Button

    private lateinit var recyclerView: RecyclerView
    private var adapter: VideoAdapter? = null
    private val app = VideoAPP
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_reproducir)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = VideoAdapter()
        recyclerView.adapter = adapter
        lifecycleScope.launch {

            val list = app.room.VideoDAO().getAll()
            adapter?.addItems(list)
        }
    }
}