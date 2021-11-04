package ru.freeit.notes.presentation.screens.note

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.chip.Chip
import com.google.android.material.snackbar.Snackbar
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.databinding.NoteScreenBinding
import ru.freeit.notes.presentation.MainActivity

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


class NoteScreen : Fragment() {

    companion object {
        private const val noteIdKey = "note_id_key"
        fun newInstance(noteId: Long) = NoteScreen().apply {
            arguments = bundleOf(noteIdKey to noteId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NoteScreenBinding.inflate(inflater)

        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val noteId = arguments?.getLong(noteIdKey, -1L) ?: -1L

        val noteRepo = (requireContext().applicationContext as App).noteRepo
        val tagRepo = (requireContext().applicationContext as App).tagRepo
        val viewModel = ViewModelProvider(this, NoteViewModelFactory(noteId, noteRepo, tagRepo)).get(NoteViewModel::class.java)

        binding.addTagButton.setOnClickListener { TagDialog().show(parentFragmentManager) }

        TagDialogListener(parentFragmentManager).listen(viewLifecycleOwner) { title ->
            viewModel.addTag(title)
        }

        viewModel.observeTags(viewLifecycleOwner) { tags ->
            binding.tags.removeAllViews()
            for (tag in tags) {
                val chip = Chip(requireContext())
                chip.setCloseIconResource(R.drawable.ic_delete_24)
                chip.setOnCloseIconClickListener { viewModel.removeTag(tag) }
                chip.text = tag.title()
                binding.tags.addView(chip)
            }
            val addChip = Chip(requireContext())
            addChip.setChipBackgroundColorResource(R.color.orange_500)
            addChip.setChipIconResource(R.drawable.ic_add_24)
            addChip.setTextColor(Color.WHITE)
            addChip.setText(R.string.tag)
            addChip.chipIconTint = ColorStateList.valueOf(Color.WHITE)
            addChip.setOnClickListener { TagDialog().show(parentFragmentManager) }
            binding.tags.addView(addChip)
        }

        viewModel.observeStatus(viewLifecycleOwner) { status ->
            when (status) {
                is NoteStatus.TitleEmpty -> {
                    Snackbar.make(binding.root, getString(R.string.title_is_empty), Snackbar.LENGTH_SHORT).show()
                }
                is NoteStatus.AlreadyAdded -> {
                    binding.titleEdit.setText(status.title())
                    binding.applyButton.text = getString(R.string.save)
                }
                is NoteStatus.SuccessAdded,
                is NoteStatus.SuccessEdited -> {
                    parentFragmentManager.popBackStack()
                }
            }
        }

        binding.applyButton.setOnClickListener {
            binding.titleEdit.error = null
            viewModel.apply(binding.titleEdit.text.toString())
        }

        return binding.root
    }
}