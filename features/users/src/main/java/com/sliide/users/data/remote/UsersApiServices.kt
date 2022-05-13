package com.sliide.users.data.remote

import com.sliide.users.data.entities.UserEntity
import retrofit2.Call
import retrofit2.http.GET

interface UsersApiServices {

    @GET("users")
    fun getAllUsers(): Call<List<UserEntity>>
}
