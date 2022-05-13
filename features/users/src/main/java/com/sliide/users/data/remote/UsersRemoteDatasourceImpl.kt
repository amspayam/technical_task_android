package com.sliide.users.data.remote

import com.sliide.remote.network.Resource
import com.sliide.remote.network.awaitResult
import com.sliide.users.data.entities.UserEntity

class UsersRemoteDatasourceImpl(
    private val api: UsersApiServices
) : UsersRemoteDatasource {
    override suspend fun getUsers(): Resource<List<UserEntity>> {
        return api.getAllUsers().awaitResult { it }
    }
}