package com.ezzy.adanianpixabay.data.repository

import com.ezzy.adanianpixabay.data.PixabayApi
import com.ezzy.adanianpixabay.data.local.ImageDatabase
import com.ezzy.adanianpixabay.data.local.dao.ImageDao
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

//    override fun fetchImages() = networkBoundResource(
//        query = {
//            imageDao.getImagesFromCache()
//        },
//        fetch = {
//            delay(2000)
//            pixabayApi.getImages()
//        },
//        saveFetchResult = { imageDto->
//            imageDatabase.withTransaction {
//                imageDao.deleteAllImages()
//                imageDao.insertImageToCache(imageDto.hits.map { it.toImage() })
//            }
//        }
//    )
}