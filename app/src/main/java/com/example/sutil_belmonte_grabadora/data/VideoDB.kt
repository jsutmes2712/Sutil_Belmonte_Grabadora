package com.example.sutil_belmonte_grabadora.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(
    entities = [Video::class],
    version = 1
)
abstract class VideoDB:RoomDatabase() {
    abstract fun VideoDAO(): VideoDAO
}

