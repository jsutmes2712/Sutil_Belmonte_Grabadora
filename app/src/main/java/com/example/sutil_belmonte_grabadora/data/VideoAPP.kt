package com.example.sutil_belmonte_grabadora.data

import android.app.Application
import androidx.room.Room

class VideoAPP: Application() {

    companion object {
        lateinit var room: VideoDB
    }

    override fun onCreate() {
        super.onCreate()
        room = Room.databaseBuilder(applicationContext, VideoDB::class.java, "video").build()
    }
}
