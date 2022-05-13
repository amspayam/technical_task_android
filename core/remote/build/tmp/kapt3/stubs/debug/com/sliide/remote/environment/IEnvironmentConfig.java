package com.sliide.remote.environment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sliide/remote/environment/IEnvironmentConfig;", "", "baseURL", "", "logLevel", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "remote_debug"})
public abstract interface IEnvironmentConfig {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String baseURL();
    
    @org.jetbrains.annotations.NotNull()
    public abstract okhttp3.logging.HttpLoggingInterceptor.Level logLevel();
}