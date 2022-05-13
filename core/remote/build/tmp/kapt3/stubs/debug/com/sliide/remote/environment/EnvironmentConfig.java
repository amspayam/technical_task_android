package com.sliide.remote.environment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u0082\u0001\u0002\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/sliide/remote/environment/EnvironmentConfig;", "Lcom/sliide/remote/environment/IEnvironmentConfig;", "()V", "baseURL", "", "logLevel", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "Development", "Production", "Lcom/sliide/remote/environment/EnvironmentConfig$Development;", "Lcom/sliide/remote/environment/EnvironmentConfig$Production;", "remote_debug"})
public abstract class EnvironmentConfig implements com.sliide.remote.environment.IEnvironmentConfig {
    
    private EnvironmentConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String baseURL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.logging.HttpLoggingInterceptor.Level logLevel() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sliide/remote/environment/EnvironmentConfig$Development;", "Lcom/sliide/remote/environment/EnvironmentConfig;", "()V", "remote_debug"})
    public static final class Development extends com.sliide.remote.environment.EnvironmentConfig {
        @org.jetbrains.annotations.NotNull()
        public static final com.sliide.remote.environment.EnvironmentConfig.Development INSTANCE = null;
        
        private Development() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/sliide/remote/environment/EnvironmentConfig$Production;", "Lcom/sliide/remote/environment/EnvironmentConfig;", "()V", "remote_debug"})
    public static final class Production extends com.sliide.remote.environment.EnvironmentConfig {
        @org.jetbrains.annotations.NotNull()
        public static final com.sliide.remote.environment.EnvironmentConfig.Production INSTANCE = null;
        
        private Production() {
            super();
        }
    }
}