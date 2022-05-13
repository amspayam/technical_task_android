package com.sliide.adduser.presentation

import androidx.lifecycle.MutableLiveData
import com.sliide.adduser.R
import com.sliide.adduser.data.entities.AddUserResponseEntity
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.adduser.domain.model.AddUserResponseModel
import com.sliide.adduser.domain.usecase.AddUserUseCase
import com.sliide.remote.network.executeUseCase
import com.sliie.components.base.viewmodel.BaseViewModel
import com.sliie.components.base.viewmodel.MessageMaster
import com.sliie.components.base.viewmodel.MessageTypeEnum
import come.sliide.base.view.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val addUserUseCase: AddUserUseCase
) : BaseViewModel() {

    // State view for request to useCase
    val addUserStateViewLiveData = MutableLiveData<ViewState<AddUserResponseModel>>()

    fun addUser(username: String?, email: String?, gender: String?) {
        val isValid =
            addUserValidation(
                username = username,
                email = email,
                gender = gender
            )
        if (!isValid)
            return

        // Remove all job
        removeAllJob()

        // Creating request model
        val requestModel =
            AddUserRequestModel(
                name = username!!,
                email = email!!,
                gender = gender!!
            )

        // Update view for Loading view
        addUserStateViewLiveData.postValue(ViewState.ViewLoading)
        track {
            addUserUseCase.executeAsync(requestModel).executeUseCase({
                addUserStateViewLiveData.postValue(ViewState.ViewData(it))
            }, {
                // Update view for show Error
                addUserStateViewLiveData.postValue(ViewState.ViewError(it.message))
            })
        }

    }

    private fun addUserValidation(
        username: String?,
        email: String?,
        gender: String?
    ): Boolean {
        var isValid = true
        if (username.isNullOrEmpty()) {
            message.value = MessageMaster(
                type = MessageTypeEnum.VIEW,
                messageResourceId = R.string.fieldRequired,
                viewId = R.id.usernameEditText
            )
            isValid = false
        }
        if (email.isNullOrEmpty()) {
            message.value = MessageMaster(
                type = MessageTypeEnum.VIEW,
                messageResourceId = R.string.fieldRequired,
                viewId = R.id.emailEditText
            )
            isValid = false
        }
        if (gender.isNullOrEmpty()) {
            message.value = MessageMaster(
                type = MessageTypeEnum.VIEW,
                messageResourceId = R.string.fieldRequired,
                viewId = R.id.genderDropDown
            )
            isValid = false
        }
        return isValid
    }
}