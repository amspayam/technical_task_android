package com.sliide.users.presentation.adapter.viewholder

import com.sliide.components.R
import com.sliide.users.databinding.ItemUserBinding
import com.sliide.users.domain.model.UserModel
import com.sliie.components.base.adapter.BaseViewHolder

class UserViewHolder(
    val binding: ItemUserBinding,
    private val onClickItemListener: (position: Int, item: UserModel) -> Unit
) : BaseViewHolder<UserModel>(binding.root) {


    override fun bind(data: UserModel) {
        // Name
        binding.userNameTextView.text = data.name
        // Email
        binding.emailTextView.text = data.email
        // Gender
        binding.genderImageview.setImageResource(
            if (data.gender == "male") R.drawable.ic_male_36dp
            else R.drawable.ic_female_36dp
        )
        // Status
        binding.statusTextview.text = data.status

        // root ClickListener
        binding.root.setOnLongClickListener {
            onClickItemListener.invoke(adapterPosition, data)
            true
        }
    }
}