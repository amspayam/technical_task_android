package com.sliide.adduser.domain.model

data class AddUserResponseModel(
    val id: String,
    val name: String,
    val email: String,
    val gender: String,
    val status: String
)
