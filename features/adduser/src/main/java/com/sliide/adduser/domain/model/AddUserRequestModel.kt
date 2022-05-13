package com.sliide.adduser.domain.model


data class AddUserRequestModel(
    val name: String,
    val email: String,
    val gender: String
)