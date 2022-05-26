package com.sliide.adduser.di

import com.sliide.adduser.data.AddUserRepositoryImpl
import com.sliide.adduser.data.remote.AddUserApiServices
import com.sliide.adduser.data.remote.AddUserRemoteDatasource
import com.sliide.adduser.data.remote.AddUserRemoteDatasourceImpl
import com.sliide.adduser.domain.AddUserRepository
import com.sliide.remote.di.NormalRetrofitClient
import com.sliide.remote.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AddUserModule {

    @Singleton
    @Provides
    fun providesAddUserRemoteData(
        @NormalRetrofitClient retrofit: Retrofit,
        schedulerProvider: SchedulerProvider
    ): AddUserRemoteDatasource {
        return AddUserRemoteDatasourceImpl(
            api = retrofit.create(AddUserApiServices::class.java),
            schedulerProvider = schedulerProvider
        )
    }

    @Singleton
    @Provides
    fun provideAddUserRepository(
        remote: AddUserRemoteDatasource
    ): AddUserRepository {
        return AddUserRepositoryImpl(remote = remote)
    }
}
