package com.example.myapplication.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.myapplication.db.IBaseDb
import com.example.myapplication.model.Photo

@Dao
interface PhotoDao : IBaseDb<Photo>{

    @Insert(onConflict = REPLACE)
    suspend fun insertAll(photos: List<Photo>)

    @Query("select * from photo")
    fun getAll(): List<Photo>
}