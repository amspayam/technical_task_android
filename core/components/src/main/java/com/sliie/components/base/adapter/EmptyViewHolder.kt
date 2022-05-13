package com.sliie.components.base.adapter

import android.view.View

class EmptyViewHolder(view: View) : BaseViewHolder<Unit>(view) {
    override fun bind(data: Unit) {}
}