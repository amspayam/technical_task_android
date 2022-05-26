package com.sliide.users.presentation

import androidx.lifecycle.MutableLiveData
import com.sliide.remote.utils.collectData
import com.sliide.users.domain.model.UserModel
import com.sliide.users.domain.usecase.DeleteUserUseCase
import com.sliide.users.domain.usecase.UsersUseCase
import com.sliie.components.base.viewmodel.BaseViewModel
import com.sliie.components.utils.SingleLiveEvent
import come.sliide.base.view.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : BaseViewModel() {
    // State view for request to usersUseCase
    val usersStateViewLiveData by lazy { MutableLiveData<ViewState<List<UserModel>>>() }

    // State view for request to deleteUserUseCase
    val deleteUserStateViewLiveData by lazy { SingleLiveEvent<ViewState<String>>() }

    init {
        getUsers()
    }

    fun getUsers() {
        // Remove all job
        removeAllJob()

        track {
            usersUseCase().collectLatest { resource ->
                resource.collectData(
                    ifSuccess = { users ->
                        users?.let { usersStateViewLiveData.postValue(ViewState.ViewData(it)) }
                    },
                    ifError = {
                        // Update view for show Error
                        usersStateViewLiveData.postValue(ViewState.ViewError(it.message))
                    },
                    ifLoading = {
                        // Update view for Loading view
                        usersStateViewLiveData.postValue(ViewState.ViewLoading)
                    }
                )
            }
        }
    }

    fun deleteUser(userId: String, userName: String) {
        // Remove all job
        removeAllJob()

        track {
            deleteUserUseCase(userId).collectLatest { resource ->
                resource.collectData(
                    ifSuccess = {
                        deleteUserStateViewLiveData.postValue(ViewState.ViewData(userName))
                        getUsers()
                    },
                    ifError = {
                        // Update view for show Error
                        deleteUserStateViewLiveData.postValue(ViewState.ViewError(it.message))
                    }, ifLoading = {
                        // Update view for Loading view
                        deleteUserStateViewLiveData.postValue(ViewState.ViewLoading)
                    }
                )
            }
        }
    }
}