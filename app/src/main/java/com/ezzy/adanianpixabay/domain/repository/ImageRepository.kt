package com.ezzy.adanianpixabay.domain.repository

import com.ezzy.adanianpixabay.common.Resource2
import com.ezzy.adanianpixabay.data.remote.dto.ImageDto
import com.ezzy.adanianpixabay.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    /**
     *Get all images
     * */
    suspend fun getImages(): ImageDto

    /**
     * Search image from the API
     * */
    suspend fun searchImage(keyword: String): ImageDto

//    fun fetchImages(): Flow<Resource2<List<Image>>>

}