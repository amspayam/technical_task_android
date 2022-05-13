package com.sliide.users.presentation

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sliide.users.R
import com.sliide.users.databinding.FragmentUsersBinding
import com.sliide.users.presentation.adapter.UserAdapter
import com.sliide.users.presentation.adapter.UserDecoration
import com.sliie.components.base.BaseFragment
import com.sliie.components.base.viewmodel.MessageMaster
import com.sliie.components.base.viewmodel.MessageTypeEnum
import come.sliide.base.view.onViewData
import come.sliide.base.view.onViewError
import come.sliide.base.view.onViewLoading
import dagger.hilt.android.AndroidEntryPoint
import viewLifecycleLazy

@AndroidEntryPoint
class UsersFragment : BaseFragment<UsersViewModel>(R.layout.fragment_users) {

    override val viewModel: UsersViewModel by viewModels()
    private val binding by viewLifecycleLazy { FragmentUsersBinding.bind(requireView()) }
    private val userAdapter = UserAdapter(
        onClickItemListener = { _, item ->
            showDeleteDialog(userId = item.id, userName = item.name)
        }
    )

    override fun setupViews() {
        binding.usersRecyclerView.apply {
            itemAnimator = DefaultItemAnimator()
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(UserDecoration(requireContext()))
            adapter = userAdapter
        }
    }

    override fun setupToolbar() {
        binding.toolbar.setOnIconListener(onClickListener = {
            navigateToAddUserFragment()
        })
    }

    override fun setupListener() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.getUsers()
        }
    }

    override fun setupObserveData() {
        // Observe Users
        viewModel.usersStateViewLiveData.observe(viewLifecycleOwner) { result ->
            result.onViewLoading { binding.swipeRefresh.isRefreshing = true }
                .onViewData { users ->
                    binding.swipeRefresh.isRefreshing = false
                    userAdapter.setItems(users)
                }
                .onViewError { status, messages ->
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.SNACK_BAR,
                            message = "$status $messages"
                        )
                    )
                    binding.swipeRefresh.isRefreshing = false
                }
        }

        // Observe Users
        viewModel.deleteUserStateViewLiveData.observe(viewLifecycleOwner) { result ->
            result.onViewLoading { binding.swipeRefresh.isRefreshing = true }
                .onViewData { username ->
                    binding.swipeRefresh.isRefreshing = false
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.TOAST,
                            message = "$username was deleted successfully."
                        )
                    )
                }
                .onViewError { status, messages ->
                    showMessage(
                        MessageMaster(
                            type = MessageTypeEnum.SNACK_BAR,
                            message = "$status $messages"
                        )
                    )
                    binding.swipeRefresh.isRefreshing = false
                }
        }
    }

    private fun showDeleteDialog(userId: String, userName: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setMessage(getString(R.string.deleteQuestion, userName))
            .setPositiveButton(getString(R.string.deleteButtonLabel)) { dialog, _ ->
                viewModel.deleteUser(userId = userId, userName = userName)
                dialog.dismiss()
            }
            .setNegativeButton(getString(R.string.cancelButtonLabel)) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun navigateToAddUserFragment() {
        val action = UsersFragmentDirections.actionUsersFragmentToAddUserFragment()
        findNavController().navigate(action)
    }

}