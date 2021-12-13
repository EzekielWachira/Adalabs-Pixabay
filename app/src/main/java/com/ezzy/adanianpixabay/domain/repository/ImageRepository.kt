package com.ezzy.adanianpixabay.domain.repository

import com.ezzy.adanianpixabay.data.remote.dto.ImageDto

interface ImageRepository {

    /**
     *Get all images
     * */
    suspend fun getImages(): ImageDto

    /**
     * Search image from the API
     * */
    suspend fun searchImage(keyword: String): ImageDto

}