package com.sliide.adduser.domain.usecase

import com.sliide.adduser.domain.AddUserRepository
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.adduser.domain.model.AddUserResponseModel
import com.sliide.remote.network.Resource
import com.sliide.remote.network.map
import come.sliide.base.usecase.AsyncSuspendUseCase
import javax.inject.Inject

class AddUserUseCase @Inject constructor(
    private val repository: AddUserRepository
) : AsyncSuspendUseCase<AddUserRequestModel, Resource<AddUserResponseModel?>> {

    override suspend fun executeAsync(rq: AddUserRequestModel): Resource<AddUserResponseModel?> {
        return repository.addUser(addUserRequestModel = rq).map {
            it?.toModel()
        }
    }
}