package ru.freeit.notes.presentation.screens.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.databinding.NoteScreenBinding

class NoteScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NoteScreenBinding.inflate(inflater)

        val repo = (requireContext().applicationContext as App).repo
        val viewModel = ViewModelProvider(this, NoteViewModelFactory(repo))
            .get(NoteViewModel::class.java)

        viewModel.observeStatus(viewLifecycleOwner) { addedStatus ->
            when (addedStatus) {
                AddNoteStatus.EMPTY_TITLE -> {
                    binding.titleEdit.error = getString(R.string.title_is_empty)
                }
                AddNoteStatus.SUCCESS_ADDED -> {
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