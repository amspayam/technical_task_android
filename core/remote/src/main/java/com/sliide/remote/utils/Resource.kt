package com.sliide.remote.utils

sealed class Resource<out T> {
    data class Success<T>(val data: T? = null, val source: DataSource = DataSource.REMOTE) :
        Resource<T>()

    data class Failure(
        val failureData: FailureData
    ) :
        Resource<Nothing>()

    object Loading : Resource<Nothing>()
}

inline fun <R, T> Resource<T>.collectData(
    ifSuccess: (data: T?) -> R,
    ifError: (failureData: FailureData) -> R,
    ifLoading: () -> R
): R {
    return when (this) {
        is Resource.Success<T> -> ifSuccess(data)
        is Resource.Failure -> ifError(failureData)
        is Resource.Loading -> ifLoading()
    }
}

fun <T, R> Resource<T>.map(isSuccess: (T?) -> R): Resource<R> {
    return when (this) {
        is Resource.Success -> Resource.Success(isSuccess.invoke(data))
        is Resource.Failure -> Resource.Failure(failureData)
        is Resource.Loading -> Resource.Loading
    }
}

enum class DataSource {
    CACHE,
    REMOTE
}

data class FailureData(val code: Int, val message: String)