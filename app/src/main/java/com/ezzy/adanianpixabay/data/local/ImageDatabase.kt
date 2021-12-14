package com.ezzy.adanianpixabay.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ezzy.adanianpixabay.data.local.dao.ImageDao
import com.ezzy.adanianpixabay.domain.model.Image

@Database(
    entities = [Image::class],
    version = 1,
    exportSchema = true
)
abstract class ImageDatabase: RoomDatabase(){

    abstract fun imageDao(): ImageDao

}