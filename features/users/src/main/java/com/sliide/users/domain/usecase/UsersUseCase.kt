package com.sliide.users.domain.usecase

import com.sliide.remote.network.Resource
import com.sliide.remote.network.map
import com.sliide.users.domain.UsersRepository
import com.sliide.users.domain.model.UserModel
import come.sliide.base.usecase.AsyncSuspendUseCase
import javax.inject.Inject

class UsersUseCase @Inject constructor(
    private val repository: UsersRepository
) : AsyncSuspendUseCase<Unit, Resource<List<UserModel>?>> {

    override suspend fun executeAsync(rq: Unit): Resource<List<UserModel>?> {
        return repository.getAllUsers().map { users ->
            users?.map { user ->
                user.toModel()
            }
        }

    }
}