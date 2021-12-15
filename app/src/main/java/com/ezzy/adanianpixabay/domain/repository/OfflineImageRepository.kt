package com.ezzy.adanianpixabay.domain.repository

import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface OfflineImageRepository {

    suspend fun insertImage(images: List<Image>)

    fun getImages(): Flow<List<Image>>

    fun searchImage(keyword: String): Flow<List<Image>>

    suspend fun deleteImage(image: Image)

    suspend fun deleteAllImages()

}