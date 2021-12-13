package com.ezzy.adanianpixabay.data.repository

import com.ezzy.adanianpixabay.data.PixabayApi
import com.ezzy.adanianpixabay.data.remote.dto.ImageDto
import com.ezzy.adanianpixabay.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val pixabayApi: PixabayApi
): ImageRepository {

    override suspend fun getImages(): ImageDto {
        return pixabayApi.getImages()
    }

    override suspend fun searchImage(keyword: String): ImageDto {
        return pixabayApi.searchImage(keyword = keyword)
    }
}