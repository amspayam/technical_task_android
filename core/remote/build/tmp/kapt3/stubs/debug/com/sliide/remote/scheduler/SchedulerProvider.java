package com.sliide.remote.scheduler;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sliide/remote/scheduler/SchedulerProvider;", "", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "io", "ui", "remote_debug"})
public abstract interface SchedulerProvider {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.CoroutineDispatcher io();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.CoroutineDispatcher ui();
}