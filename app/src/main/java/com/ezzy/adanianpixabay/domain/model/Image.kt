package com.ezzy.adanianpixabay.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "images")
data class Image (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val imageId: Int,
    val collections: Int,
    val comments: Int,
    val downloads: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val tags: String,
    val user: String,
    val userImageURL: String,
    val views: Int,
    val webformatHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int
): Serializable