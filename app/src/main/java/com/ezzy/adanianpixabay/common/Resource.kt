package com.ezzy.adanianpixabay.common

sealed class Resource<out T> {
    class Loading<T>: Resource<T>()
    object Empty: Resource<Nothing>()
    data class Success<out T>(val data: T): Resource<T>()
    data class Failure<out T>(val errorMessage: String?): Resource<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> failed(message: String) = Failure<T>(message)
    }
}