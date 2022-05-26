package com.sliie.components.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J!\u0010\u0010\u001a\u00020\r2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0012\"\u00020\u000fH\u0004\u00a2\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/sliie/components/base/BaseFragment;", "VM", "Lcom/sliie/components/base/viewmodel/BaseViewModel;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "layout", "", "(I)V", "viewModel", "getViewModel", "()Lcom/sliie/components/base/viewmodel/BaseViewModel;", "Lcom/sliie/components/base/viewmodel/BaseViewModel;", "onClick", "", "v", "Landroid/view/View;", "onClickListeners", "views", "", "([Landroid/view/View;)V", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setupBackStackEntry", "setupListener", "setupObserveData", "setupToolbar", "setupViews", "components_debug"})
public abstract class BaseFragment<VM extends com.sliie.components.base.viewmodel.BaseViewModel> extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.Nullable()
    private final VM viewModel = null;
    
    public BaseFragment(int layout) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public VM getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public void setupViews() {
    }
    
    public void setupToolbar() {
    }
    
    public void setupBackStackEntry() {
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