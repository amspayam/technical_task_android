package com.sliide.users.testdataprovider

import com.sliide.users.domain.model.UserModel

class AllUserDataProvider {

    companion object {

        fun getAllUsers(): List<UserModel> {
            val list = mutableListOf<UserModel>()
            list.add(UserModel(id = "1", name = "p", email = "a", gender = "d", status = "s"))
            list.add(UserModel(id = "1", name = "p", email = "a", gender = "d", status = "s"))
            list.add(UserModel(id = "1", name = "p", email = "a", gender = "d", status = "s"))
            list.add(UserModel(id = "1", name = "p", email = "a", gender = "d", status = "s"))
            return list
        }

    }
}