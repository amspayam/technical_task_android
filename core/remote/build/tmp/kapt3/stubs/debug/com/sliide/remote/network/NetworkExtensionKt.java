package com.sliide.remote.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001aA\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r0\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001a\u00bc\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r0\u00112+\b\u0002\u0010\u0014\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\u000e0\u0015\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00112:\b\u0002\u0010\u001a\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u001am\u0010 \u001a\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\f2!\u0010!\u001a\u001d\u0012\u0013\u0012\u0011H\u000e\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\r0\u00112!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\r0\u0011H\u0086\b\u00f8\u0001\u0001\u00a2\u0006\u0002\u0010%\u001a6\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u0002H\u000e0\f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r0\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006\'"}, d2 = {"ERROR_MESSAGE", "", "ERROR_RESPONSE_UNKNOWN", "", "fromNetworkThrowable", "Lcom/sliide/remote/network/RestErrorResponse;", "throwable", "", "getErrorModel", "json", "getFlatErrorModel", "awaitResult", "Lcom/sliide/remote/network/Resource;", "R", "T", "Lretrofit2/Call;", "map", "Lkotlin/Function1;", "(Lretrofit2/Call;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueue", "onSuccess", "Lretrofit2/Response;", "Lkotlin/ParameterName;", "name", "response", "", "onFailure", "Lkotlin/Function2;", "errorCode", "onCanceled", "Lkotlin/Function0;", "(Lretrofit2/Call;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeUseCase", "ifSuccess", "value", "ifError", "error", "(Lcom/sliide/remote/network/Resource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isSuccess", "remote_debug"})
public final class NetworkExtensionKt {
    private static final int ERROR_RESPONSE_UNKNOWN = -1;
    private static final java.lang.String ERROR_MESSAGE = "Can Not Connect To Server";
    
    public static final <R extends java.lang.Object, T extends java.lang.Object>R executeUseCase(@org.jetbrains.annotations.NotNull()
    com.sliide.remote.network.Resource<? extends T> $this$executeUseCase, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> ifSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.sliide.remote.network.RestErrorResponse, ? extends R> ifError) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, R extends java.lang.Object>com.sliide.remote.network.Resource<R> map(@org.jetbrains.annotations.NotNull()
    com.sliide.remote.network.Resource<? extends T> $this$map, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> isSuccess) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object, R extends java.lang.Object>java.lang.Object awaitResult(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<T> $this$awaitResult, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends R> map, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sliide.remote.network.Resource<? extends R>> p2) {
        return null;
    }
    
    private static final <T extends java.lang.Object, R extends java.lang.Object>java.lang.Object enqueue(retrofit2.Call<T> $this$enqueue, kotlin.jvm.functions.Function1<? super T, ? extends R> map, kotlin.jvm.functions.Function1<? super retrofit2.Response<T>, kotlin.Unit> onSuccess, kotlin.jvm.functions.Function2<? super java.lang.Throwable, ? super java.lang.Integer, kotlin.Unit> onFailure, kotlin.jvm.functions.Function0<kotlin.Unit> onCanceled, kotlin.coroutines.Continuation<? super com.sliide.remote.network.Resource<? extends R>> p5) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.sliide.remote.network.RestErrorResponse fromNetworkThrowable(@org.jetbrains.annotations.NotNull()
    java.lang.Throwable throwable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Throws(exceptionClasses = {java.lang.Exception.class})
    public static final com.sliide.remote.network.RestErrorResponse getFlatErrorModel(@org.jetbrains.annotations.Nullable()
    java.lang.String json) throws java.lang.Exception {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.sliide.remote.network.RestErrorResponse getErrorModel(@org.jetbrains.annotations.Nullable()
    java.lang.String json) {
        return null;
    }
}