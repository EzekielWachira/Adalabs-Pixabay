package com.ezzy.adanianpixabay.domain.usecase.fetch_images

import android.media.Image
import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.common.Resource2
import com.ezzy.adanianpixabay.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FetchImagesUseCase @Inject constructor(
    private val imagesRepository: ImageRepository
) {

    suspend operator fun invoke(): Flow<Resource2<List<Image>>> = flow {
        try {
            emit(Resource2.Loading())

        } catch (e: HttpException) {
            emit(Resource2.Error(e.localizedMessage ?: "An error occurred, check your internet connection"))
        } catch (e: IOException) {
            emit(Resource2.Error(e.localizedMessage ?: "An error occurred, check your internet connection"))
        }
    }

}