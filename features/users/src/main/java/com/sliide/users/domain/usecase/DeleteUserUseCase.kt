package com.sliide.users.domain.usecase

import com.sliide.remote.network.Resource
import com.sliide.users.domain.UsersRepository
import come.sliide.base.usecase.AsyncSuspendUseCase
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UsersRepository
) : AsyncSuspendUseCase<String, Resource<Unit>> {

    override suspend fun executeAsync(rq: String): Resource<Unit> {
        return repository.deleteUser(userId = rq)
    }
}