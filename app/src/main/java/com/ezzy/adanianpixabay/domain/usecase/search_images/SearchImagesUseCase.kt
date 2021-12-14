package com.ezzy.adanianpixabay.domain.usecase.search_images

import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.data.remote.dto.ImageDto
import com.ezzy.adanianpixabay.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SearchImagesUseCase @Inject constructor(
    private val imagesRepository: ImageRepository
) {

    suspend operator fun invoke(keyword: String): Flow<Resource<ImageDto>> = flow {
        try {
            emit(Resource.Loading())
            val response = imagesRepository.searchImage(keyword)
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Failure(e.localizedMessage ?: "An expected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Failure("Couldn't connect to server, check your internet connection"))
        }
    }

}