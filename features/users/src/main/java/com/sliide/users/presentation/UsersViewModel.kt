package com.sliide.users.presentation

import androidx.lifecycle.MutableLiveData
import com.sliide.remote.network.executeUseCase
import com.sliide.users.domain.model.UserModel
import com.sliide.users.domain.usecase.UsersUseCase
import com.sliie.components.base.viewmodel.BaseViewModel
import come.sliide.base.view.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : BaseViewModel() {
    // State view for request to useCase
    val usersStateViewLiveData = MutableLiveData<ViewState<List<UserModel>>>()

    init {
        getUsers()
    }

    fun getUsers() {
        // Remove all job
        removeAllJob()

        // Update view for Loading view
        usersStateViewLiveData.postValue(ViewState.ViewLoading)
        track {
            usersUseCase.executeAsync(Unit).executeUseCase({
                usersStateViewLiveData.postValue(ViewState.ViewData(it))
            }, {
                // Update view for show Error
                usersStateViewLiveData.postValue(ViewState.ViewError(it.message))
            })
        }
    }

    fun deleteUser(userId: String) {
        TODO("Not yet implemented")
    }
}