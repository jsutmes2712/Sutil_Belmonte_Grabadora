package com.example.sutil_belmonte_grabadora.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface VideoDAO {

    @Query("Select * From Video")
    suspend fun getAll(): List<Video>

    @Update
    suspend fun updateVideo(video: Video)

    @Insert
    suspend fun insertVideo(video: Video)

    @Delete
    suspend fun deleteVideo(video: Video)

}
