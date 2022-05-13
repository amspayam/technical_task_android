package com.sliide.adduser.data.remote

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.remote.network.Resource
import com.sliide.remote.network.awaitResult

class AddUserRemoteDatasourceImpl(
    private val api: AddUserApiServices
) : AddUserRemoteDatasource {

    override suspend fun addUser(addUserRequestEntity: AddUserRequestEntity): Resource<AddUserResponseEntity?> {
        return api.addUser(
            addUserRequestEntity = addUserRequestEntity
        ).awaitResult { it }
    }
}