package com.sliide.adduser.data.entities

import com.sliide.adduser.domain.model.AddUserResponseModel

data class AddUserResponseEntity(
    val id: String?,
    val name: String?,
    val email: String?,
    val gender: String?,
    val status: String?
) {
    fun toModel() = AddUserResponseModel(
        id = id ?: "",
        name = name ?: "",
        email = email ?: "",
        gender = gender ?: "",
        status = status ?: ""
    )
}
