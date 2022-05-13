package com.sliide.adduser.data.remote

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.remote.network.Resource

interface AddUserRemoteDatasource {
    suspend fun addUser(addUserRequestEntity: AddUserRequestEntity): Resource<AddUserResponseEntity>
}
