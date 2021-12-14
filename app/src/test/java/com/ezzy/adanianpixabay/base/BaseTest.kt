package com.ezzy.adanianpixabay.base

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.ezzy.adanianpixabay.data.local.ImageDatabase
import com.ezzy.adanianpixabay.data.local.dao.ImageDao
import com.github.testcoroutinesrule.TestCoroutineRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE, sdk = [Config.OLDEST_SDK])
abstract class BaseTest {
    lateinit var imageDatabase: ImageDatabase
    lateinit var imageDao: ImageDao
    @get: Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Before
    open fun setUp() {
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        imageDatabase = Room.inMemoryDatabaseBuilder(appContext, ImageDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        imageDao = imageDatabase.imageDao()
    }

    @After
    fun teardown() {
        imageDatabase.clearAllTables()
        imageDatabase.close()
    }

}