package com.sliie.components.base.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0011R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/sliie/components/base/adapter/BaseViewHolder;", "T", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "listener", "Lkotlin/Function1;", "Lcom/sliie/components/base/adapter/BaseAction;", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "bind", "data", "(Ljava/lang/Object;)V", "components_debug"})
public abstract class BaseViewHolder<T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    public kotlin.jvm.functions.Function1<? super com.sliie.components.base.adapter.BaseAction, kotlin.Unit> listener;
    
    public BaseViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.sliie.components.base.adapter.BaseAction, kotlin.Unit> getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.sliie.components.base.adapter.BaseAction, kotlin.Unit> p0) {
    }
    
    public abstract void bind(@org.jetbrains.annotations.NotNull()
    T data);
}