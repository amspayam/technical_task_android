package com.sliide.remote.environment

import okhttp3.logging.HttpLoggingInterceptor

interface IEnvironmentConfig {
    fun baseURL(): String
    fun logLevel(): HttpLoggingInterceptor.Level
}
