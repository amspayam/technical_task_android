package com.sliide.adduser.data.remote

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface AddUserApiServices {

    @POST("users")
    suspend fun addUser(
        @Header("Authorization") token: String = "Bearer e51e73b385fbde444487ab1ed0d87f2ec77f3c9f50e391a62980abbc4d86418a",
        @Body addUserRequestEntity: AddUserRequestEntity
    ): AddUserResponseEntity
}
