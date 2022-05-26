package com.sliide.users.data

import com.sliide.remote.utils.Resource
import com.sliide.users.data.entities.UserEntity
import com.sliide.users.data.remote.UsersRemoteDatasource
import com.sliide.users.domain.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val remote: UsersRemoteDatasource
) : UsersRepository {

    override suspend fun getAllUsers(): Flow<Resource<List<UserEntity>>> {
        return remote.getUsers()
    }

    override suspend fun deleteUser(userId: String): Flow<Resource<Unit>> {
        return remote.deleteUser(userId)
    }
}