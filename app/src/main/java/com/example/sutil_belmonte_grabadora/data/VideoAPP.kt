package com.example.sutil_belmonte_grabadora.data

import android.app.Application
import androidx.room.Room

class VideoAPP: Application() {
    val room = Room.databaseBuilder(applicationContext, VideoDB::class.java, "student").build()
}