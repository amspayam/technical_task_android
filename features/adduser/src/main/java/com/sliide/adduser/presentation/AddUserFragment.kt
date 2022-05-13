package com.sliide.adduser.presentation

import android.view.View
import androidx.fragment.app.viewModels
import com.sliide.adduser.R
import com.sliide.adduser.databinding.FragmentAddUserBinding
import com.sliie.components.base.BaseFragment
import com.sliie.components.base.viewmodel.MessageMaster
import com.sliie.components.base.viewmodel.MessageTypeEnum
import com.sliie.components.components.dropdown.model.DropDownModel
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
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.TOAST,
                            message = "${it.name} was added successfully"
                        )
                    )
                    binding.saveUserButton.stopLoading()
                }
                .onViewError { status, messages ->
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.SNACK_BAR,
                            message = "$status $messages"
                        )
                    )
                    binding.saveUserButton.stopLoading()
                }
        }
    }

    override fun showMessage(message: MessageMaster) {
        binding.saveUserButton.stopLoading()
        super.showMessage(message)
        if (message.type == MessageTypeEnum.VIEW) {
            when (message.viewId) {
                R.id.usernameEditText -> binding.usernameEditText.setError(
                    message.text
                )
                R.id.emailEditText -> binding.emailEditText.setError(
                    message.text
                )
                R.id.genderDropDown -> binding.genderDropDown.setError(message.text)
            }
        }
    }

}