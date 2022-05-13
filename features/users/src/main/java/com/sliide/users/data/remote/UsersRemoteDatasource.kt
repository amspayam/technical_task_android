package com.sliide.users.data.remote

import com.sliide.remote.network.Resource
import com.sliide.users.data.entities.UserEntity

interface UsersRemoteDatasource {
    suspend fun getUsers(): Resource<List<UserEntity>?>
    suspend fun deleteUser(userId: String): Resource<Unit>
}
