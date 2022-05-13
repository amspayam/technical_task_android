package com.sliide.users.data

import com.sliide.remote.network.Resource
import com.sliide.users.data.entities.UserEntity
import com.sliide.users.data.remote.UsersRemoteDatasource
import com.sliide.users.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remote: UsersRemoteDatasource
) : UserRepository {

    override suspend fun getAllUsers(): Resource<List<UserEntity>> {
        return remote.getUsers()
    }
}