package com.sliie.components.base.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003J\u0014\u0010\u0017\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007J\u0016\u0010\u0019\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u001e\u0010\u001f\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010!\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0003JL\u0010\"\u001a\u00020\u00142B\u0010\u0005\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0004J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003J\u0016\u0010$\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0016J\u0016\u0010%\u001a\u00020\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0002RL\u0010\u0005\u001a@\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/sliie/components/base/adapter/BaseRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sliie/components/base/adapter/BaseViewHolder;", "", "()V", "diffCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "oldItems", "newItems", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "mItems", "", "getMItems", "()Ljava/util/List;", "setMItems", "(Ljava/util/List;)V", "addItem", "", "item", "addItemFirst", "addItems", "items", "addItemsFirst", "clear", "position", "", "clearAll", "getItemCount", "onBindViewHolder", "holder", "replaceItem", "setDiffUtilsCallback", "setItem", "setItems", "setItemsByDiffUtils", "components_debug"})
public abstract class BaseRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sliie.components.base.adapter.BaseViewHolder<? extends java.lang.Object>> {
    private kotlin.jvm.functions.Function2<? super java.util.List<? extends java.lang.Object>, ? super java.util.List<? extends java.lang.Object>, ? extends androidx.recyclerview.widget.DiffUtil.Callback> diffCallback;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Object> mItems;
    
    public BaseRecyclerAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.List<java.lang.Object> getMItems() {
        return null;
    }
    
    protected final void setMItems(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> p0) {
    }
    
    protected final void setDiffUtilsCallback(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.util.List<? extends java.lang.Object>, ? super java.util.List<? extends java.lang.Object>, ? extends androidx.recyclerview.widget.DiffUtil.Callback> diffCallback) {
    }
    
    public final void setItem(@org.jetbrains.annotations.NotNull()
    java.lang.Object item) {
    }
    
    public void setItems(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> items) {
    }
    
    private final void setItemsByDiffUtils(java.util.List<? extends java.lang.Object> items) {
    }
    
    public final void replaceItem(int position, @org.jetbrains.annotations.NotNull()
    java.lang.Object item) {
    }
    
    public final void addItem(@org.jetbrains.annotations.NotNull()
    java.lang.Object item) {
    }
    
    public final void addItemFirst(@org.jetbrains.annotations.NotNull()
    java.lang.Object item) {
    }
    
    public final void addItems(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> items) {
    }
    
    public void addItemsFirst(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> items) {
    }
    
    public final void clear(int position) {
    }
    
    public final void clearAll() {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sliie.components.base.adapter.BaseViewHolder<? extends java.lang.Object> holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
}