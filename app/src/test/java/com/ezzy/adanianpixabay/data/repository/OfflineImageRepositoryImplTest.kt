package com.ezzy.adanianpixabay.data.repository

import androidx.lifecycle.asLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ezzy.adanianpixabay.base.BaseTest
import com.ezzy.adanianpixabay.domain.repository.OfflineImageRepository
import com.ezzy.adanianpixabay.testImages
import com.jraska.livedata.test
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class OfflineImageRepositoryImplTest: BaseTest() {
    private lateinit var offlineImageRepository: OfflineImageRepository

    override fun setUp() {
        super.setUp()
        imageDao = imageDatabase.imageDao()
        offlineImageRepository = OfflineImageRepositoryImpl(imageDao)
    }
    @Test
    fun `test saving images`() {
        runBlockingTest {
            offlineImageRepository.insertImage(testImages)
            val images = offlineImageRepository.getImages().asLiveData()
            images.test().assertValue(testImages)

        }
    }
    @Test
    fun `test delete single image`() {
        runBlockingTest {
            offlineImageRepository.insertImage(testImages)
            offlineImageRepository.deleteImage(testImages[0])
            val images = offlineImageRepository.getImages().asLiveData()
            images.test().assertValue {
                !it.contains(testImages[0])
            }
        }
    }
    @Test
    fun `test deleting all images`() {
        runBlockingTest {
            offlineImageRepository.insertImage(testImages)
            offlineImageRepository.deleteAllImages()
            val images = offlineImageRepository.getImages().asLiveData()
            images.test().assertValue {
                it.isEmpty()
            }
        }
    }
    @Test
    fun `test searching an image`() {
        runBlockingTest {
            val expectedImageId = 1
            offlineImageRepository.insertImage(testImages)
            val searchedImages = offlineImageRepository.searchImage("Flowers")
                .asLiveData()
            searchedImages.test().assertValue {
                it[0].id == expectedImageId
            }
        }
    }
}