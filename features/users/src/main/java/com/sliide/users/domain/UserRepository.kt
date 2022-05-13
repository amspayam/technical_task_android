package com.sliide.users.domain

import com.sliide.remote.network.Resource
import com.sliide.users.data.entities.UserEntity

interface UserRepository {
    suspend fun getAllUsers(): Resource<List<UserEntity>>
}