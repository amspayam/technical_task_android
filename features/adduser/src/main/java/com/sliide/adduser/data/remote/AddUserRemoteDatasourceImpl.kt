package com.sliide.adduser.data.remote

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.remote.network.Resource
import com.sliide.remote.network.awaitResult

class AddUserRemoteDatasourceImpl(
    private val api: AddUserApiServices
) : AddUserRemoteDatasource {

    override suspend fun addUser(addUserRequestEntity: AddUserRequestEntity): Resource<AddUserResponseEntity> {
        return api.addUser(
            token = "Bearer e51e73b385fbde444487ab1ed0d87f2ec77f3c9f50e391a62980abbc4d86418a",
            addUserRequestEntity = addUserRequestEntity
        ).awaitResult { it }
    }
}