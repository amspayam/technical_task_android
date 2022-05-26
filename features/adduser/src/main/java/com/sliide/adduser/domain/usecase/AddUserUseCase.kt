package com.sliide.adduser.domain.usecase

import com.sliide.adduser.domain.AddUserRepository
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.adduser.domain.model.AddUserResponseModel
import com.sliide.remote.utils.Resource
import com.sliide.remote.utils.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AddUserUseCase @Inject constructor(
    private val repository: AddUserRepository
) {

    suspend operator fun invoke(rq: AddUserRequestModel): Flow<Resource<AddUserResponseModel?>> {
        return repository.addUser(addUserRequestModel = rq).map { resource ->
            resource.map { it?.toModel() }
        }
    }

}