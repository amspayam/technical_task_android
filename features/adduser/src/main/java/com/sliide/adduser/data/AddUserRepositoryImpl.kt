package com.sliide.adduser.data

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.adduser.data.remote.AddUserRemoteDatasource
import com.sliide.adduser.domain.AddUserRepository
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.remote.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddUserRepositoryImpl @Inject constructor(
    private val remote: AddUserRemoteDatasource
) : AddUserRepository {

    override suspend fun addUser(addUserRequestModel: AddUserRequestModel): Flow<Resource<AddUserResponseEntity?>> {
        return remote.addUser(
            addUserRequestEntity = AddUserRequestEntity(
                name = addUserRequestModel.name,
                email = addUserRequestModel.email,
                gender = addUserRequestModel.gender,
                status = "active"
            )
        )
    }
}