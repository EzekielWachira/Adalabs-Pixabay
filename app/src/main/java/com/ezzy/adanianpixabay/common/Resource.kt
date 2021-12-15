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

typealias SimpleResource = Resource2<Unit>

sealed class Resource2<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource2<T>(data)
    class Loading<T>(data: T? = null) : Resource2<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource2<T>(data, message)

}
