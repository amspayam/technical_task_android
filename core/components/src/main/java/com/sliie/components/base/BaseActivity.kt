package com.sliie.components.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sliie.components.base.viewmodel.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(),
    View.OnClickListener {

    open val viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViews()
        setupListener()
        setupToolbar()
        setupObserveData()
    }

    open fun setupViews(){}

    open fun setupToolbar() {}

    open fun setupObserveData() {}

    open fun setupListener() {}

    override fun onClick(v: View?) {
    }

    protected fun onClickListeners(vararg views: View) {
        for (view in views)
            view.setOnClickListener(this)
    }

}