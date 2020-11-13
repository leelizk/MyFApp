package com.example.myapplication.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.db.dao.PhotoDao
import com.example.myapplication.model.Photo


@Database(entities = arrayOf(Photo::class), version = 1) // 定义版本号，便于升级管理
abstract class AppDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao // 获取DAO
}
