package com.sliide.remote.network

import com.sliide.remote.scheduler.SchedulerProvider
import com.sliide.remote.utils.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class NetworkBoundResource<T>(
    private val schedulerProvider: SchedulerProvider
) {

    fun asFlow(): Flow<Resource<T>> = flow {
        emit(Resource.Loading)
        val remoteResponse =
            safeApiCall(dispatcher = schedulerProvider.io()) {
                remoteFetch()
            }

        when (remoteResponse) {
            is ResultWrapper.Success -> {
                emit(Resource.Success(data = remoteResponse.value, DataSource.REMOTE))
            }

            is ResultWrapper.Failure -> {
                emit(
                    Resource.Failure(
                        failureData = FailureData(
                            remoteResponse.code,
                            remoteResponse.message ?: NetworkCodes.GENERIC_ERROR_MESSAGE
                        )
                    )
                )
            }
        }
    }

    abstract suspend fun remoteFetch(): T?
}
