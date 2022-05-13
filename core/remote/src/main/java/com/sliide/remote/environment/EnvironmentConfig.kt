package com.sliide.remote.environment

import okhttp3.logging.HttpLoggingInterceptor

private const val currentServerVersion = "v2"
private const val BASE_PRODUCTION_URL = "https://gorest.co.in/public/"
private const val BASE_DEVELOPMENT_URL = "https://gorest.co.in/public/"

sealed class EnvironmentConfig : IEnvironmentConfig {

    object Development : EnvironmentConfig()
    object Production : EnvironmentConfig()

    override fun baseURL() = when (this) {
        Production ->
            "$BASE_PRODUCTION_URL$currentServerVersion/"
        Development ->
            "$BASE_DEVELOPMENT_URL$currentServerVersion/"
    }

    override fun logLevel() = when (this) {
        Production ->
            HttpLoggingInterceptor.Level.NONE
        Development ->
            HttpLoggingInterceptor.Level.BODY
    }
}
