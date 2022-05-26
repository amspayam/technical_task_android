package com.sliide.users.domain.usecase

import com.sliide.remote.utils.Resource
import com.sliide.remote.utils.map
import com.sliide.users.domain.UsersRepository
import com.sliide.users.domain.model.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<UserModel>?>> {
        return repository.getAllUsers().map { resource ->
            resource.map { users ->
                users?.map {
                    it.toModel()
                }
            }
        }
    }
}