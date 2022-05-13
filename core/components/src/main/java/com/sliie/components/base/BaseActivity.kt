package com.sliie.components.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sliie.components.base.viewmodel.BaseViewModel
import com.sliie.components.base.viewmodel.MessageMaster
import com.sliie.components.base.viewmodel.MessageTypeEnum
import com.sliie.components.components.snackbar.SnackBarComponent
import com.sliie.components.components.snackbar.SnackBarComponent.Companion.VIEW_PARENT
import com.sliie.components.components.snackbar.StateEnums

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(),
    View.OnClickListener {

    open val viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel?.message?.observe(this) {
            showMessage(it)
        }

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

    open fun showMessage(message: MessageMaster) {
        message.text = message.message ?: message.messageResourceId?.let {
            getString(it)
        } ?: "Error"
        when (message.type) {
            MessageTypeEnum.TOAST -> {
                Toast.makeText(
                    this,
                    message.text,
                    Toast.LENGTH_LONG
                ).show()
            }
            MessageTypeEnum.SNACK_BAR -> {
                SnackBarComponent(findViewById(VIEW_PARENT), message.text, StateEnums.ERROR)
            }
        }
    }

}