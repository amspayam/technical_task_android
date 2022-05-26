package com.sliide.adduser.data.remote

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.remote.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AddUserRemoteDatasource {
    suspend fun addUser(addUserRequestEntity: AddUserRequestEntity): Flow<Resource<AddUserResponseEntity?>>
}
