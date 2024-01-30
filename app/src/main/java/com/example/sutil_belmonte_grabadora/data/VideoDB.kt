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

    companion object {
        @Volatile
        private var INSTANCE: VideoDB? = null

        fun getInstance(context: Context): VideoDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VideoDB::class.java,
                    "tu_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}

