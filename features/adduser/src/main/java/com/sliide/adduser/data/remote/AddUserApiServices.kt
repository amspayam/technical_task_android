package com.sliide.adduser.data.remote

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AddUserApiServices {

    @POST("users")
    fun addUser(
        @Header("Authorization") token: String,
        @Body addUserRequestEntity: AddUserRequestEntity
    ): Call<AddUserResponseEntity>
}
