package com.sliie.components.components.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.sliide.components.R
import com.sliide.components.databinding.ComponentToolbarBinding
import com.sliie.components.extension.view.gone
import com.sliie.components.extension.view.invisible
import com.sliie.components.extension.view.visible

class ToolbarComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val BACK = 0
        private const val SIMPLE = 1
        private const val CLOSE = 2
        private const val ICON = 3
    }

    private var binding: ComponentToolbarBinding =
        ComponentToolbarBinding.inflate(LayoutInflater.from(context), this, true)
    var text: String? = ""
        set(value) {
            field = value
            binding.titleTextview.text = field
        }
    private var toolbarType = SIMPLE
    private var icon = R.drawable.ic_next_32dp

    init {
        layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ToolbarComponent, 0, 0)
            text = typedArray.getString(R.styleable.ToolbarComponent_android_text).toString()
            toolbarType = typedArray.getInt(
                R.styleable.ToolbarComponent_toolbarType,
                SIMPLE
            )
            icon = typedArray.getResourceId(
                R.styleable.ToolbarComponent_android_icon,
                SIMPLE
            )
            typedArray.recycle()
            initView()
        }
    }

    private fun initView() {
        when (toolbarType) {
            BACK -> {
                text?.let {
                    binding.titleTextview.text = it
                }
                binding.backImageView.setImageResource(R.drawable.ic_arrow_back_24dp)
                binding.titleTextview.visible()
                binding.backImageView.visible()
                binding.iconImageView.gone()
            }
            SIMPLE -> {
                text?.let {
                    binding.titleTextview.text = it
                }
                binding.titleTextview.visible()
                binding.backImageView.invisible()
                binding.iconImageView.gone()
            }
            CLOSE -> {
                text?.let {
                    binding.titleTextview.text = it
                }
                binding.backImageView.setImageResource(R.drawable.ic_close_24dp)
                binding.titleTextview.visible()
                binding.backImageView.visible()
                binding.iconImageView.gone()
            }
            ICON -> {
                text?.let {
                    binding.titleTextview.text = it
                }
                binding.iconImageView.setImageResource(icon)
                binding.titleTextview.visible()
                binding.backImageView.invisible()
                binding.iconImageView.visible()
            }
        }

        binding.backImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    fun setOnIconListener(onClickListener: () -> Unit) {
        binding.iconImageView.setOnClickListener {
            onClickListener.invoke()
        }
    }

}