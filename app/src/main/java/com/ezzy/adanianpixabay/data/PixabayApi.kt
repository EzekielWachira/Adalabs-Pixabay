package com.ezzy.adanianpixabay.data

import com.ezzy.adanianpixabay.data.remote.dto.ImageDto
import com.ezzy.adanianpixabay.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    suspend fun getImages(
        @Query("key") key: String = Constants.API_KEY,
        @Query("image_type") imageType: String = "photo"
    ): ImageDto

    @GET("/api/")
    suspend fun searchImage(
        @Query("key") key: String = Constants.API_KEY,
        @Query("q") keyword: String,
        @Query("image_type") imageType: String = "photo"
    ): ImageDto

}