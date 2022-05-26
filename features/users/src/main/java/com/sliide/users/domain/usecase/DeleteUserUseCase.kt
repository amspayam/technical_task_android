package com.sliide.users.domain.usecase

import com.sliide.remote.utils.Resource
import com.sliide.remote.utils.map
import com.sliide.users.domain.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UsersRepository
) {

    suspend operator fun invoke(rq: String): Flow<Resource<Boolean>> {
        return repository.deleteUser(userId = rq).map {
            it.map {
                true
            }
        }
    }

}