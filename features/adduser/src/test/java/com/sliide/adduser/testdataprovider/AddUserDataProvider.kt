package com.sliide.adduser.testdataprovider

import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.adduser.domain.model.AddUserResponseModel


class AddUserDataProvider {

    companion object {

        fun AddUserRequest(): AddUserRequestModel {
            return AddUserRequestModel(
                name = "John Doe",
                email = "johndoe@gmail.com",
                gender = "male"
            )
        }

        fun AddUserResponse(): AddUserResponseModel {
            return AddUserResponseModel(
                id = "2031",
                name = "John Doe",
                email = "johndoe@gmail.com",
                gender = "male",
                status = "active"
            )
        }

    }
}