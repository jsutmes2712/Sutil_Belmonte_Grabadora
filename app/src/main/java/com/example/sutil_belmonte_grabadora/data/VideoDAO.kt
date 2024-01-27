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
    fun getAll(): LiveData<List<Video>>

    @Update
    fun updateVideo(video: Video)

    @Insert
    fun insertVideo(video: Video)

    @Delete
    fun deleteVideo(video: Video)

}
