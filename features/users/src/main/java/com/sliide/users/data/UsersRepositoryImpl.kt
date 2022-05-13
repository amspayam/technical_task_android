package com.sliide.users.data

import com.sliide.remote.network.Resource
import com.sliide.users.data.entities.UserEntity
import com.sliide.users.data.remote.UsersRemoteDatasource
import com.sliide.users.domain.UsersRepository
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val remote: UsersRemoteDatasource
) : UsersRepository {

    override suspend fun getAllUsers(): Resource<List<UserEntity>?> {
        return remote.getUsers()
    }

    override suspend fun deleteUser(userId: String): Resource<Unit> {
        return remote.deleteUser(userId)
    }
}