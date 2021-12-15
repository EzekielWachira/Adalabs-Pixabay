package com.ezzy.adanianpixabay.data.local.dao

import androidx.room.*
import com.ezzy.adanianpixabay.domain.model.Image
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {

    /**
     * Insert an image record to offline cache
     * @param image
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageToCache(image: List<Image>)

    /**
     * Get all the images from offline cache
     * */
    @Query("SELECT * FROM `images`")
    fun getImagesFromCache(): Flow<List<Image>>

    /**
     * Search an image in the offline cache
     * @param keyword
     * */
    @Query("SELECT * FROM `images` WHERE `tags` LIKE '%' || :keyword || '%'")
    fun searchImages(keyword: String): Flow<List<Image>>

    /**
     * Delete an image from offline cache
     * @param image
     * */
    @Delete
    suspend fun deleteImageFromCache(image: Image)

    /**
     * Delete all images from the cache
     * */
    @Query("DELETE FROM `images`")
    suspend fun deleteAllImages()

}