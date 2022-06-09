package com.sliide.users.data.remote

import com.sliide.users.data.entities.UserEntity
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface UsersApiServices {

    @GET("users")
    suspend fun getAllUsers(): List<UserEntity>

    @DELETE("users/{userId}")
    suspend fun deleteUser(
        @Header("Authorization") token: String = "Bearer e51e73b385fbde444487ab1ed0d87f2ec77f3c9f50e391a62980abbc4d86418a",
        @Path("userId") userId: String
    ): Response<Unit>
}