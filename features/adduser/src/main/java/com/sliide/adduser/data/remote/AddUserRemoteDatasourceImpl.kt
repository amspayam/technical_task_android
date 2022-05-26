package com.sliide.adduser.data.remote

import com.sliide.adduser.data.entities.AddUserRequestEntity
import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.remote.network.NetworkBoundResource
import com.sliide.remote.scheduler.SchedulerProvider
import com.sliide.remote.utils.Resource
import kotlinx.coroutines.flow.Flow

class AddUserRemoteDatasourceImpl(
    private val api: AddUserApiServices,
    private val schedulerProvider: SchedulerProvider
) : AddUserRemoteDatasource {

    override suspend fun addUser(
        addUserRequestEntity: AddUserRequestEntity
    ): Flow<Resource<AddUserResponseEntity?>> {
        return object :
            NetworkBoundResource<AddUserResponseEntity>(schedulerProvider = schedulerProvider) {
            override suspend fun remoteFetch() = api.addUser(
                addUserRequestEntity = addUserRequestEntity
            )
        }.asFlow()
    }
}