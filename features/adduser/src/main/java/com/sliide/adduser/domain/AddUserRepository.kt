package com.sliide.adduser.domain

import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.remote.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AddUserRepository {
    suspend fun addUser(addUserRequestModel: AddUserRequestModel): Flow<Resource<AddUserResponseEntity?>>
}