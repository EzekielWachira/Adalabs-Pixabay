package com.ezzy.adanianpixabay.di

import android.content.Context
import androidx.room.Room
import com.ezzy.adanianpixabay.data.local.ImageDatabase
import com.ezzy.adanianpixabay.data.local.dao.ImageDao
import com.ezzy.adanianpixabay.data.repository.OfflineImageRepositoryImpl
import com.ezzy.adanianpixabay.domain.repository.OfflineImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideImageDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ImageDatabase::class.java, "images.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideImageDao(database: ImageDatabase): ImageDao = database.imageDao()

    @Provides
    @Singleton
    fun provideOfflineImageRepo(imageDao: ImageDao): OfflineImageRepository =
        OfflineImageRepositoryImpl(imageDao)

}