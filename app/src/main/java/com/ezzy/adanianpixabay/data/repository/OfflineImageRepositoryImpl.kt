package com.ezzy.adanianpixabay.data.repository

import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.data.local.dao.ImageDao
import com.ezzy.adanianpixabay.domain.model.Image
import com.ezzy.adanianpixabay.domain.repository.OfflineImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineImageRepositoryImpl @Inject constructor(
    private val imageDao: ImageDao
): OfflineImageRepository {

    override suspend fun insertImage(images: List<Image>) {
        return imageDao.insertImageToCache(images)
    }

    override fun getImages(): Flow<List<Image>> {
        return imageDao.getImagesFromCache()
    }

    override fun searchImage(keyword: String): Flow<List<Image>> {
        return imageDao.searchImages(keyword)
    }

    override suspend fun deleteImage(image: Image) {
        return imageDao.deleteImageFromCache(image)
    }

    override suspend fun deleteAllImages() {
        return imageDao.deleteAllImages()
    }
}