package com.sliide.users.di

import com.sliide.remote.di.NormalRetrofitClient
import com.sliide.remote.scheduler.SchedulerProvider
import com.sliide.users.data.UsersRepositoryImpl
import com.sliide.users.data.remote.UsersApiServices
import com.sliide.users.data.remote.UsersRemoteDatasource
import com.sliide.users.data.remote.UsersRemoteDatasourceImpl
import com.sliide.users.domain.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Singleton
    @Provides
    fun providesUserRemoteData(
        @NormalRetrofitClient retrofit: Retrofit,
        schedulerProvider: SchedulerProvider
    ): UsersRemoteDatasource {
        return UsersRemoteDatasourceImpl(
            api = retrofit.create(UsersApiServices::class.java),
            schedulerProvider = schedulerProvider
        )
    }

    @Singleton
    @Provides
    fun provideUsersRepository(
        remote: UsersRemoteDatasource
    ): UsersRepository {
        return UsersRepositoryImpl(remote = remote)
    }
}
