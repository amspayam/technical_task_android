package com.sliie.components.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J!\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0010\"\u00020\rH\u0004\u00a2\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lcom/sliie/components/base/BaseActivity;", "VM", "Lcom/sliie/components/base/viewmodel/BaseViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "viewModel", "getViewModel", "()Lcom/sliie/components/base/viewmodel/BaseViewModel;", "Lcom/sliie/components/base/viewmodel/BaseViewModel;", "onClick", "", "v", "Landroid/view/View;", "onClickListeners", "views", "", "([Landroid/view/View;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupListener", "setupObserveData", "setupToolbar", "setupViews", "components_debug"})
public abstract class BaseActivity<VM extends com.sliie.components.base.viewmodel.BaseViewModel> extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.Nullable()
    private final VM viewModel = null;
    
    public BaseActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public VM getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public void setupViews() {
    }
    
    public void setupToolbar() {
    }
    
    public void setupObserveData() {
    }
    
    public void setupListener() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    protected final void onClickListeners(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
}