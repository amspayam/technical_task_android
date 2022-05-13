package com.sliie.components.base.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005JC\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0012\u00a2\u0006\u0002\b\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/sliie/components/base/viewmodel/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "jobs", "Ljava/util/HashMap;", "", "Lkotlinx/coroutines/Job;", "message", "Lcom/sliie/components/utils/SingleLiveEvent;", "Lcom/sliie/components/base/viewmodel/MessageMaster;", "getMessage", "()Lcom/sliie/components/utils/SingleLiveEvent;", "removeAllJob", "", "removeJobByName", "jobName", "track", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "components_debug"})
public class BaseViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.sliie.components.utils.SingleLiveEvent<com.sliie.components.base.viewmodel.MessageMaster> message = null;
    private final java.util.HashMap<java.lang.String, kotlinx.coroutines.Job> jobs = null;
    
    public BaseViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sliie.components.utils.SingleLiveEvent<com.sliie.components.base.viewmodel.MessageMaster> getMessage() {
        return null;
    }
    
    public final void track(@org.jetbrains.annotations.Nullable()
    java.lang.String jobName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
    }
    
    public final void removeJobByName(@org.jetbrains.annotations.NotNull()
    java.lang.String jobName) {
    }
    
    public final void removeAllJob() {
    }
}