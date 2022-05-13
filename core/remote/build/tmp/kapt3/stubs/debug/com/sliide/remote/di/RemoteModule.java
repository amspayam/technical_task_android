package com.sliide.remote.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH\u0007J\u0012\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00a8\u0006\u001b"}, d2 = {"Lcom/sliide/remote/di/RemoteModule;", "", "()V", "clientBuilder", "Lokhttp3/OkHttpClient;", "loggerInterceptor", "Lokhttp3/Interceptor;", "authInterceptor", "tokenAuthenticator", "Lokhttp3/Authenticator;", "provideAuthOkHttpClient", "provideAuthRetrofitClient", "Lretrofit2/Retrofit;", "okHttpClient", "environmentConfig", "Lcom/sliide/remote/environment/IEnvironmentConfig;", "provideEnvironmentConfig", "isDebugBuild", "", "provideIsDebugBuild", "provideLoggingInterceptor", "iEnvironmentConfig", "provideNormalOkHttpClient", "provideNormalRetrofitClient", "provideSchedulerProvider", "Lcom/sliide/remote/scheduler/SchedulerProvider;", "retrofitBuilder", "remote_debug"})
@dagger.Module()
public final class RemoteModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.sliide.remote.di.RemoteModule INSTANCE = null;
    
    private RemoteModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @IsDebugBuild()
    public final boolean provideIsDebugBuild() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.sliide.remote.environment.IEnvironmentConfig provideEnvironmentConfig(@IsDebugBuild()
    boolean isDebugBuild) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    @LoggerInterceptorProvider()
    public final okhttp3.Interceptor provideLoggingInterceptor(@org.jetbrains.annotations.NotNull()
    com.sliide.remote.environment.IEnvironmentConfig iEnvironmentConfig) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    @NormalOkHttpClient()
    public final okhttp3.OkHttpClient provideNormalOkHttpClient(@org.jetbrains.annotations.NotNull()
    @LoggerInterceptorProvider()
    okhttp3.Interceptor loggerInterceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    @AuthOkHttpClient()
    public final okhttp3.OkHttpClient provideAuthOkHttpClient(@org.jetbrains.annotations.NotNull()
    @LoggerInterceptorProvider()
    okhttp3.Interceptor loggerInterceptor, @org.jetbrains.annotations.NotNull()
    @AuthInterceptorProvider()
    okhttp3.Interceptor authInterceptor, @org.jetbrains.annotations.NotNull()
    okhttp3.Authenticator tokenAuthenticator) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    @NormalRetrofitClient()
    public final retrofit2.Retrofit provideNormalRetrofitClient(@org.jetbrains.annotations.NotNull()
    @NormalOkHttpClient()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.sliide.remote.environment.IEnvironmentConfig environmentConfig) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    @AuthRetrofitClient()
    public final retrofit2.Retrofit provideAuthRetrofitClient(@org.jetbrains.annotations.NotNull()
    @AuthOkHttpClient()
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull()
    com.sliide.remote.environment.IEnvironmentConfig environmentConfig) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.sliide.remote.scheduler.SchedulerProvider provideSchedulerProvider() {
        return null;
    }
    
    private final retrofit2.Retrofit retrofitBuilder(okhttp3.OkHttpClient okHttpClient, com.sliide.remote.environment.IEnvironmentConfig environmentConfig) {
        return null;
    }
    
    private final okhttp3.OkHttpClient clientBuilder(okhttp3.Interceptor loggerInterceptor, okhttp3.Interceptor authInterceptor, okhttp3.Authenticator tokenAuthenticator) {
        return null;
    }
}