package com.sliide.remote.network

import come.sliide.base.extension.GsonUtils.toObjectByGson
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.resume

sealed class Resource<out V> {
    data class Success<V>(val value: V) : Resource<V>()
    data class Error(val error: RestErrorResponse) : Resource<Nothing>()
}

private const val ERROR_RESPONSE_UNKNOWN = -1

inline fun <R, T> Resource<T>.executeUseCase(
    ifSuccess: (value: T) -> R,
    ifError: (error: RestErrorResponse) -> R
): R {
    return when (this) {
        is Resource.Success<T> -> ifSuccess(value)
        is Resource.Error -> ifError(error)
    }
}

fun <T, R> Resource<T>.map(isSuccess: (T) -> R): Resource<R> {
    return when (this) {
        is Resource.Success -> Resource.Success(isSuccess.invoke(value))
        is Resource.Error -> Resource.Error(error)
    }
}

suspend fun <T, R> Call<T>.awaitResult(map: (T) -> R): Resource<R> = enqueue(map)

private suspend fun <T, R> Call<T>.enqueue(
    map: (T) -> R,
    onSuccess: ((response: Response<T>) -> Unit)? = null,
    onFailure: ((throwable: Throwable, errorCode: Int) -> Unit)? = null,
    onCanceled: (() -> Unit)? = null
): Resource<R> = suspendCancellableCoroutine { continuation ->
    try {
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, throwable: Throwable) {
                handleError(ERROR_RESPONSE_UNKNOWN, throwable)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    try {
                        onSuccess?.invoke(response)
                        continuation.resume(Resource.Success(map(response.body()!!)))
                    } catch (throwable: Throwable) {
                        handleError(response.code(), throwable)
                    }
                } else {
                    handleError(response.code(), HttpException(response))
                }
            }

            private fun handleError(errorCode: Int, throwable: Throwable) {
                onFailure?.invoke(throwable, errorCode)
                continuation.resume(Resource.Error(fromNetworkThrowable(throwable)))
            }
        })
    } catch (throwable: Throwable) {
        continuation.resume(Resource.Error(fromNetworkThrowable(throwable)))
    }

    continuation.invokeOnCancellation {
        onCanceled?.invoke()
        cancel()
    }
}


private const val ERROR_MESSAGE = "Can Not Connect To Server"
fun fromNetworkThrowable(throwable: Throwable): RestErrorResponse {

    throwable.printStackTrace()

    return if (throwable is HttpException) {
        val networkError = throwable.response()
        val errorBodyString = networkError?.errorBody()?.string().toString()
        return try {
            getFlatErrorModel(errorBodyString)
        } catch (e: Exception) {
            getErrorModel(errorBodyString)
        }
    } else {
        RestErrorResponse(-1, ERROR_MESSAGE)
    }

}

@Throws(Exception::class)
fun getFlatErrorModel(json: String?): RestErrorResponse {
    json?.let {
        return json.toObjectByGson(RestErrorResponse::class.java)
    } ?: run {
        return RestErrorResponse(-1, ERROR_MESSAGE)
    }
}

fun getErrorModel(json: String?): RestErrorResponse {
    json?.let {
        return try {
            json.toObjectByGson(RestErrorResponse::class.java)
        } catch (e: Exception) {
            RestErrorResponse(-1, ERROR_MESSAGE)
        }
    } ?: run {
        return RestErrorResponse(-1, ERROR_MESSAGE)
    }
}