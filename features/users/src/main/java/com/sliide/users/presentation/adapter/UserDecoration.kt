package com.sliide.users.presentation.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.sliie.components.extension.permitive.dpToPx

class UserDecoration(context: Context) : ItemDecoration() {

    private val padding8dp = 8.dpToPx(context)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)

        outRect.right = padding8dp
        outRect.left = padding8dp
        if (position == 0) outRect.top = padding8dp
        if (position == state.itemCount - 1) outRect.bottom = padding8dp
    }

}