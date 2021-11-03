package ru.freeit.notes.presentation.screens.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.databinding.NotesScreenBinding
import ru.freeit.notes.presentation.screens.note.NoteScreen

class NotesScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NotesScreenBinding.inflate(inflater)

        val repo = (requireContext().applicationContext as App).repo
        val viewModel = ViewModelProvider(this, NotesViewModelFactory(this, savedInstanceState, repo))
            .get(NotesViewModel::class.java)

        viewModel.init()
        viewModel.observeNotes(viewLifecycleOwner) { notes ->
            // TODO добавить notes в список
        }

        binding.addNoteButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NoteScreen())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }
}