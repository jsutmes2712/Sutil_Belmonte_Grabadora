package com.example.sutil_belmonte_grabadora.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Video::class], version = 1, exportSchema = false)
abstract class VideoDB:RoomDatabase() {

    abstract fun VideoDAO(): VideoDAO

    companion object {
        @Volatile
        private var INSTANCE: VideoDB? = null
        fun getDatabase(context: Context): VideoDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VideoDB::class.java,
                    "items_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
