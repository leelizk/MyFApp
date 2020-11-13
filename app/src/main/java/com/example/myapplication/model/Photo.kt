package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "photo")
data class Photo{


    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
    @ColumnInfo(name = "album_id")
    val albumId: Int=0
    @ColumnInfo(name = "title")
    val title: String=""
    @ColumnInfo(name = "url")
    val url: String=""
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String=""
}
