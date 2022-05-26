package com.sliide.users.data.remote

import com.sliide.remote.utils.Resource
import com.sliide.users.data.entities.UserEntity
import kotlinx.coroutines.flow.Flow

interface UsersRemoteDatasource {
    suspend fun getUsers(): Flow<Resource<List<UserEntity>>>
    suspend fun deleteUser(userId: String): Flow<Resource<Unit>>
}
