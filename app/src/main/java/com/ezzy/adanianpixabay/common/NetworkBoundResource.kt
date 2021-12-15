package com.ezzy.adanianpixabay.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.io.IOException
//
//inline fun <ResultType, RequestType> networkBoundResource(
//    crossinline query: () -> Flow<ResultType>,
//    crossinline fetch: suspend () -> RequestType,
//    crossinline saveFetchResult: suspend (RequestType) -> Unit,
//    crossinline shouldFetch: (ResultType) -> Boolean = { true }
//) = flow {
//    val data = query().first()
//    val flow = if (shouldFetch(data)) {
//        emit(Resource2.Loading())
//        try {
//            saveFetchResult(fetch())
//            query().map { Resource2.Success(it) }
//        } catch (e: IOException) {
//            query().map { Resource2.Error(e.localizedMessage) }
//        }
//    } else {
//        query().map { Resource2.Success(it) }
//    }
//}