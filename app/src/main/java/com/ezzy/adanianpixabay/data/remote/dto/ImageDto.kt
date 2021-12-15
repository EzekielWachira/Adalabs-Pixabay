package com.ezzy.adanianpixabay.data.remote.dto

data class ImageDto(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)