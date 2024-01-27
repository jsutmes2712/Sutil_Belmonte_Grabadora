package com.example.sutil_belmonte_grabadora.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Video")
data class Video (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int=0,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "nombre") val nombre: String
)