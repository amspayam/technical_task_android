package com.sliide.adduser.domain

import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.remote.network.Resource

interface AddUserRepository {
    suspend fun addUser(addUserRequestModel: AddUserRequestModel): Resource<AddUserResponseEntity?>
}