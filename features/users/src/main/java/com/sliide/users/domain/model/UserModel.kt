package com.sliide.users.domain.model


data class UserModel(
    val id: String,
    val name: String,
    val email: String,
    val gender: String,
    val status: String
)