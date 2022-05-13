package com.sliide.users.data.entities

import com.sliide.users.domain.model.UserModel

data class UserEntity(
    val id: String?,
    val name: String?,
    val email: String?,
    val gender: String?,
    val status: String?
) {
    fun toModel() = UserModel(
        id = id ?: "",
        name = name ?: "",
        email = email ?: "",
        gender = gender ?: "",
        status = status ?: ""
    )
}
