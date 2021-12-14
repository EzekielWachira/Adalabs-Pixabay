package com.ezzy.adanianpixabay.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.ezzy.adanianpixabay.data.local.ImageDatabase
import com.ezzy.adanianpixabay.data.local.dao.ImageDao
import com.ezzy.adanianpixabay.testImages
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@ExperimentalCoroutinesApi
@SmallTest
@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE, sdk = [Config.OLDEST_SDK])
class ImageDaoTest {

    private lateinit var imageDatabase: ImageDatabase
    private lateinit var imageDao: ImageDao

    @ExperimentalCoroutinesApi
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        imageDatabase = Room.inMemoryDatabaseBuilder(
            context,
            ImageDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        imageDao = imageDatabase.imageDao()
    }

    @Test
    fun tesSavingImage() = runBlockingTest {
        imageDao.insertImageToCache(testImages)
        val images = imageDao.getImagesFromCache()
        images.collect {
            Truth.assertThat(it).isEqualTo(testImages)
        }
    }

    @After
    fun teardown() {
        imageDatabase.clearAllTables()
        imageDatabase.close()
    }

}