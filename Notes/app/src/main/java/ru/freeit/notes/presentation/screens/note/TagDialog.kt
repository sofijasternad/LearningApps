package ru.freeit.notes.presentation.screens.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import ru.freeit.notes.databinding.TagDialogBinding

class TagDialog : DialogFragment() {

    private var isError = false
    private val dialogTag = "tag_dialog"

    fun show(fragmentManager: FragmentManager) = show(fragmentManager, dialogTag)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = TagDialogBinding.inflate(inflater, container, false)

        isError = savedInstanceState?.getBoolean("is_error_key", false) ?: false

        binding.tagIsEmpty.isVisible = isError

        binding.okButton.setOnClickListener {
            if (binding.titleEdit.text.toString().trim().isEmpty()) {
                isError = true
                binding.tagIsEmpty.isVisible = isError
            } else {
                TagDialogListener(parentFragmentManager).giveTitle(binding.titleEdit.text.toString())
                dismiss()
            }
        }

        binding.cancelButton.setOnClickListener { dismiss() }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("is_error_key", isError)
    }

    private val Int.dp get() = (requireContext().resources.displayMetrics.density * this).toInt()

    override fun onResume() {
        super.onResume()
        val params = dialog?.window?.attributes
        params?.width = 350.dp
        dialog?.window?.attributes = params
    }

}