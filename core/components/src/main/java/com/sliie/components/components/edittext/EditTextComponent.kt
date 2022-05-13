package com.sliie.components.components.edittext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import com.sliide.components.R
import com.sliide.components.databinding.ComponentEditTextBinding
import com.sliie.components.components.snackbar.SnackBarComponent
import com.sliie.components.components.snackbar.StateEnums


class EditTextComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), TextWatcher {

    companion object {
        const val DEFAULT = -1
        const val PASSWORD = 1
        const val SEARCH = 2
        const val COPY = 3
    }

    private var binding: ComponentEditTextBinding =
        ComponentEditTextBinding.inflate(LayoutInflater.from(context), this, true)
    var text: String? = ""
        get() {
            return binding.editText.text.toString()
        }
        set(value) {
            field = value
            if (field != "null") {
                binding.editText.setText(field)
            }
        }
    var tag: String? = ""
        set(value) {
            field = value
            binding.editText.tag = field
            text = ""
        }

    private var maxLength: Int = 100
        set(value) {
            field = value
            binding.editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(field))
        }
    private var hint: String? = ""
    private var enabled: Boolean = true
    private var imeOptions: Int = EditorInfo.IME_ACTION_NEXT
    private var inputType: Int = InputType.TYPE_CLASS_TEXT
    private var type = DEFAULT
    private var drawableStart: Int? = null

    init {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.EditTextComponent, 0, 0)
            text = typedArray.getString(R.styleable.EditTextComponent_android_text).toString()
            hint = typedArray.getString(R.styleable.EditTextComponent_android_hint)

            inputType =
                typedArray.getInt(R.styleable.EditTextComponent_android_inputType, inputType)
            imeOptions =
                typedArray.getInt(R.styleable.EditTextComponent_android_imeOptions, imeOptions)
            type = typedArray.getInt(R.styleable.EditTextComponent_textType, type)
            drawableStart =
                typedArray.getResourceId(R.styleable.EditTextComponent_android_drawableStart, 0)
            enabled = typedArray.getBoolean(R.styleable.EditTextComponent_android_enabled, enabled)

            typedArray.recycle()
            initView()
        }

    }

    private fun initView() {
        initInputText()
        initEditText()
        initKind()
    }

    private fun initKind() {
        when (type) {
            SEARCH -> {
                val drawable = ContextCompat.getDrawable(context, R.drawable.ic_search_24dp)
                binding.editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    binding.editText.compoundDrawablesRelative[0],
                    binding.editText.compoundDrawablesRelative[1],
                    drawable,
                    binding.editText.compoundDrawablesRelative[3]
                )
                binding.editText.imeOptions = EditorInfo.IME_ACTION_SEARCH
            }
            PASSWORD ->
                binding.textInput.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
            COPY -> {
                val drawable = ContextCompat.getDrawable(context, R.drawable.ic_copy_24dp)
                binding.editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    binding.editText.compoundDrawablesRelative[0],
                    binding.editText.compoundDrawablesRelative[1],
                    drawable,
                    binding.editText.compoundDrawablesRelative[3]
                )
                binding.editText.isFocusableInTouchMode = false
                binding.editText.isCursorVisible = false
                binding.editText.setOnClickListener {
                    val clipboard = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
                    clipboard.addPrimaryClipChangedListener {
                        SnackBarComponent(
                            findViewById(SnackBarComponent.VIEW_PARENT),
                            "Copied to the Clipboard.",
                            StateEnums.SUCCESS
                        )
                    }
                    clipboard.setPrimaryClip(ClipData.newPlainText("Data", text))
                }
            }
            else -> initEditText()
        }
    }

    private fun initInputText() {
        binding.textInput.hint = hint
        drawableStart?.let {
            if (it != 0)
                binding.textInput.startIconDrawable = ContextCompat.getDrawable(context, it)
        }
    }

    private fun initEditText() {
        binding.editText.setText(text)
        binding.editText.inputType = inputType
        binding.editText.imeOptions = imeOptions
        binding.editText.setLines(1)
        binding.editText.maxLines = 1
        binding.editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        binding.editText.addTextChangedListener(this)
        isEnabled = enabled

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        binding.textInput.error = null
    }

    override fun afterTextChanged(s: Editable?) {
    }

    fun setError(error: String?) {
        error ?: return
        binding.textInput.error = error
    }

    override fun setEnabled(isEnabled: Boolean) {
        binding.editText.isFocusableInTouchMode = isEnabled
        binding.editText.isCursorVisible = isEnabled
    }

    fun isEmpty() = binding.editText.text.toString().isEmpty()

    fun replace(oldValue: String, newValue: String): String {
        return text?.replace(oldValue, newValue).toString()
    }

    fun setOnEditorActionListener(editTextListener: TextView.OnEditorActionListener) {
        binding.editText.setOnEditorActionListener(editTextListener)
    }

    fun addTextChangedListener(watcher: TextWatcher) {
        binding.editText.addTextChangedListener(watcher)
    }

    fun removeTextChangedListener(watcher: TextWatcher) {
        binding.editText.removeTextChangedListener(watcher)
    }

}