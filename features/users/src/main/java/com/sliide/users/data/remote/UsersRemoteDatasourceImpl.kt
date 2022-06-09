package com.sliide.users.data.remote

import com.sliide.remote.network.NetworkBoundResource
import com.sliide.remote.scheduler.SchedulerProvider
import com.sliide.remote.utils.Resource
import com.sliide.users.data.entities.UserEntity
import kotlinx.coroutines.flow.Flow

class UsersRemoteDatasourceImpl(
    private val api: UsersApiServices,
    private val schedulerProvider: SchedulerProvider
) : UsersRemoteDatasource {
    override suspend fun getUsers(): Flow<Resource<List<UserEntity>>> {
        return object :
            NetworkBoundResource<List<UserEntity>>(schedulerProvider = schedulerProvider) {
            override suspend fun remoteFetch() = api.getAllUsers()
        }.asFlow()
    }

    override suspend fun deleteUser(userId: String): Flow<Resource<Unit>> {
        return object :
            NetworkBoundResource<Unit>(schedulerProvider = schedulerProvider) {
            override suspend fun remoteFetch() = api.deleteUser(userId = userId).body()
        }.asFlow()
    }
}