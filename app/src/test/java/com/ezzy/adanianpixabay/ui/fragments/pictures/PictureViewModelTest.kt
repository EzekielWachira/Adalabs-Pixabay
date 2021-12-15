package com.ezzy.adanianpixabay.ui.fragments.pictures

import com.ezzy.adanianpixabay.base.BaseViewModelTest
import com.ezzy.adanianpixabay.common.Resource
import com.ezzy.adanianpixabay.domain.usecase.get_images.GetImagesUseCase
import com.ezzy.adanianpixabay.domain.usecase.search_images.SearchImagesUseCase
import com.ezzy.adanianpixabay.testImages
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test

class PictureViewModelTest: BaseViewModelTest() {
    private val getImagesUseCase: GetImagesUseCase = mockk()
    private val searchImagesUseCase: SearchImagesUseCase = mockk()
    private lateinit var pictureViewModel: PictureViewModel
    @Before
    fun setup() {
        pictureViewModel = PictureViewModel(getImagesUseCase, searchImagesUseCase)
    }
    @Test
    fun `test get images`() {
        coEvery {
            getImagesUseCase.invoke()
        } returns flowOf(Resource.Success(testImages))
        pictureViewModel.getImages()
        Truth.assertThat(pictureViewModel.imagesState.value).isInstanceOf(Resource.Success::class.java)
    }
}