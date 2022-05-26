package com.sliide.adduser.presentation

import com.sliide.adduser.R
import com.sliide.adduser.domain.model.AddUserRequestModel
import com.sliide.adduser.domain.model.AddUserResponseModel
import com.sliide.adduser.domain.usecase.AddUserUseCase
import com.sliide.remote.utils.collectData
import com.sliie.components.base.viewmodel.BaseViewModel
import com.sliie.components.base.viewmodel.MessageMaster
import com.sliie.components.base.viewmodel.MessageTypeEnum
import com.sliie.components.utils.SingleLiveEvent
import come.sliide.base.view.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val addUserUseCase: AddUserUseCase
) : BaseViewModel() {

    // State view for request to useCase
    val addUserStateViewLiveData by lazy { SingleLiveEvent<ViewState<AddUserResponseModel>>() }
    val validationLiveData by lazy { SingleLiveEvent<MessageMaster>() }

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
        track {
            addUserUseCase(requestModel).collectLatest { resource ->
                resource.collectData(
                    ifSuccess = { user ->
                        user?.let {
                            addUserStateViewLiveData.postValue(ViewState.ViewData(it))
                        }
                    },
                    ifError = {
                        // Update view for show Error
                        addUserStateViewLiveData.postValue(ViewState.ViewError(it.message))
                    },
                    ifLoading = {
                        addUserStateViewLiveData.postValue(ViewState.ViewLoading)
                    }
                )
            }
        }

    }

    private fun addUserValidation(
        username: String?,
        email: String?,
        gender: String?
    ): Boolean {
        var isValid = true
        if (username.isNullOrEmpty()) {
            validationLiveData.value =
                MessageMaster(
                    type = MessageTypeEnum.VIEW,
                    message = "This field is required!",
                    viewId = R.id.usernameEditText
                )
            isValid = false
        }
        if (email.isNullOrEmpty()) {
            validationLiveData.value =
                MessageMaster(
                    type = MessageTypeEnum.VIEW,
                    message = "This field is required!",
                    viewId = R.id.emailEditText
                )

            isValid = false
        }
        if (gender.isNullOrEmpty()) {
            validationLiveData.value =
                MessageMaster(
                    type = MessageTypeEnum.VIEW,
                    message = "This field is required!",
                    viewId = R.id.genderDropDown
                )

            isValid = false
        }
        return isValid
    }
}