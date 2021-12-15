package com.ezzy.adanianpixabay.domain.usecase.search_images

import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.data.remote.dto.ImageDto
import com.ezzy.adanianpixabay.data.remote.dto.toImage
import com.ezzy.adanianpixabay.domain.model.Image
import com.ezzy.adanianpixabay.domain.repository.ImageRepository
import com.ezzy.adanianpixabay.domain.repository.OfflineImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchImagesUseCase @Inject constructor(
    private val imagesRepository: ImageRepository,
    private val offlineImageRepository: OfflineImageRepository
) {

    suspend operator fun invoke(keyword: String): Flow<Resource<List<Image>>> = flow {
        try {
            emit(Resource.Loading())
            val response = imagesRepository.searchImage(keyword)
            offlineImageRepository.deleteAllImages()
            offlineImageRepository.insertImage(response.hits.map { it.toImage() })
//            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Failure(e.localizedMessage ?: "An expected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Failure("Couldn't connect to server, check your internet connection"))
        }

        offlineImageRepository.getImages().collect {
            emit(Resource.Success(it))
        }
        //emit(Resource.Success(images))
    }

}