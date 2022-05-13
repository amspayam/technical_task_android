package com.sliide.users.presentation.adapter

import android.view.ViewGroup
import com.sliide.users.R
import com.sliide.users.databinding.ItemUserBinding
import com.sliide.users.domain.model.UserModel
import com.sliide.users.presentation.adapter.viewholder.UserViewHolder
import com.sliie.components.base.adapter.BaseRecyclerAdapter
import com.sliie.components.base.adapter.BaseViewHolder
import com.sliie.components.extension.inflate

class UserAdapter(
    private val onClickItemListener: (position: Int, item: UserModel) -> Unit
) : BaseRecyclerAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        return UserViewHolder(
            binding = ItemUserBinding.bind(parent.inflate(viewType)),
            onClickItemListener = onClickItemListener
        )
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_user
    }

}


