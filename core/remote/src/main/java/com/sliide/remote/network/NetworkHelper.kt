package com.sliide.remote.network

import com.sliide.remote.utils.NetworkCodes
import com.sliide.remote.utils.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T?
): ResultWrapper<T?> {
    return withContext(dispatcher) {
        try {
            val response = apiCall.invoke()
            if (response !is Response<*>)
                ResultWrapper.Success(response)
            else {
                if (response.isSuccessful)
                    ResultWrapper.Success(response)
                else {
                    val code = response.code()
                    ResultWrapper.Failure(
                        code = code,
                    )
                }
            }
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            val message = throwable.message
            when (throwable) {
                is TimeoutCancellationException -> {
                    ResultWrapper.Failure(
                        code = NetworkCodes.TIMEOUT_ERROR,
                        message = message
                    )
                }
                is IOException -> {
                    ResultWrapper.Failure(
                        code = NetworkCodes.CONNECTION_ERROR,
                        message = message
                    )
                }
                is HttpException -> {
                    val code = throwable.code()
                    ResultWrapper.Failure(
                        code = code,
                        message = message
                    )
                }
                else -> {
                    ResultWrapper.Failure(
                        code = NetworkCodes.GENERIC_ERROR,
                        message = message
                    )
                }
            }
        }
    }
}
