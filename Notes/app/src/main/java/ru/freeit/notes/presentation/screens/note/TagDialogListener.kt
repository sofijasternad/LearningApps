package ru.freeit.notes.presentation.screens.note

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner

class TagDialogListener(private val fragmentManager: FragmentManager) {
    private val titleKey = "title_key"
    private val requestKey = "tag_dialog_result_key"

    fun listen(viewLifecycleOwner: LifecycleOwner, onTitle: (title: String) -> Unit) {
        fragmentManager.setFragmentResultListener(requestKey, viewLifecycleOwner, { requestKey, result ->
            val title = result.getString(titleKey, "")
            onTitle(title)
        })
    }

    fun giveTitle(title: String) {
        fragmentManager.setFragmentResult(requestKey, bundleOf(titleKey to title))
    }
}