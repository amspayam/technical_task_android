package com.sliide.adduser.presentation

import android.view.View
import androidx.fragment.app.viewModels
import com.sliide.adduser.R
import com.sliide.adduser.databinding.FragmentAddUserBinding
import com.sliie.components.base.BaseFragment
import com.sliie.components.components.dropdown.model.DropDownModel
import com.sliie.components.components.snackbar.SnackBarComponent
import com.sliie.components.components.snackbar.StateEnums
import com.sliie.components.extension.view.hideKeyboard
import come.sliide.base.view.onViewData
import come.sliide.base.view.onViewError
import come.sliide.base.view.onViewLoading
import dagger.hilt.android.AndroidEntryPoint
import viewLifecycleLazy

@AndroidEntryPoint
class AddUserFragment : BaseFragment<AddUserViewModel>(R.layout.fragment_add_user) {

    override val viewModel: AddUserViewModel by viewModels()
    private val binding by viewLifecycleLazy { FragmentAddUserBinding.bind(requireView()) }

    override fun setupViews() {
        binding.genderDropDown.setData(
            list = mutableListOf(
                DropDownModel(title = "Male", data = 1),
                DropDownModel(title = "Female", data = 2),
            )
        )
    }

    override fun onClick(v: View?) {
        viewModel.addUser(
            username = binding.usernameEditText.text,
            email = binding.emailEditText.text,
            gender = binding.genderDropDown.getItemSelect()?.title
        )
    }

    override fun setupListener() {
        onClickListeners(binding.saveUserButton)
    }

    override fun setupObserveData() {
        // Observe AddUser
        viewModel.addUserStateViewLiveData.observe(viewLifecycleOwner) { result ->
            result.onViewLoading { binding.saveUserButton.startLoading() }
                .onViewData {
                    binding.root.hideKeyboard()
                    SnackBarComponent(
                        view = binding.root,
                        message = "${it.name} was added successfully",
                        state = StateEnums.SUCCESS
                    )
                    binding.saveUserButton.stopLoading()
                }
                .onViewError { status, messages ->
                    SnackBarComponent(
                        view = binding.root,
                        message = "$status $messages",
                        state = StateEnums.ERROR
                    )
                    binding.saveUserButton.stopLoading()
                }
        }

        //Observe Error
        viewModel.validationLiveData.observe(viewLifecycleOwner) {
            when (it.viewId) {
                R.id.usernameEditText -> binding.usernameEditText.setError(error = it.message)
                R.id.emailEditText -> binding.emailEditText.setError(error = it.message)
                R.id.genderDropDown -> binding.genderDropDown.setError(error = it.message)
            }
        }
    }

}