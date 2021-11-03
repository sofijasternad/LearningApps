package ru.freeit.notes.presentation.screens.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.databinding.NoteScreenBinding
import ru.freeit.notes.presentation.MainActivity

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

        val noteId = requireArguments().getLong(noteIdKey, -1L)

        val repo = (requireContext().applicationContext as App).repo
        val viewModel = ViewModelProvider(this, NoteViewModelFactory(noteId, repo)).get(NoteViewModel::class.java)

        viewModel.observeStatus(viewLifecycleOwner) { status ->
            when (status) {
                is NoteStatus.TitleEmpty -> {
                    binding.titleEdit.error = getString(R.string.title_is_empty)
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