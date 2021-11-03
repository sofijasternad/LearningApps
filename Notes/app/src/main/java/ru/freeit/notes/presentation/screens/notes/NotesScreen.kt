package ru.freeit.notes.presentation.screens.notes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.databinding.NotesScreenBinding
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.presentation.MainActivity
import ru.freeit.notes.presentation.screens.note.NoteScreen

class NotesScreen : Fragment() {

    private lateinit var viewModel: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NotesScreenBinding.inflate(inflater)

        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val repo = (requireContext().applicationContext as App).repo
        viewModel = ViewModelProvider(this, NotesViewModelFactory(this, savedInstanceState, repo))
            .get(NotesViewModel::class.java)

        val adapter = NotesAdapter(object: NoteListItemCallback {
            override fun remove(note: Note) {
                viewModel.remove(note)
            }

            override fun edit(note: Note) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, NoteScreen.newInstance(note.id()))
                    .addToBackStack(null)
                    .commit()
            }
        })

        binding.noteList.adapter = adapter

        viewModel.init()
        viewModel.observeNotes(viewLifecycleOwner) { notes ->
            adapter.submitList(notes)
        }

        binding.addNoteButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, NoteScreen())
                .addToBackStack(null)
                .commit()
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.sorting_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.no_sorting -> {
                viewModel.sortDefault()
                true
            }
            R.id.create_date_sorting -> {
                viewModel.sortByCreatedDate()
                true
            }
            R.id.edited_date_sorting -> {
                viewModel.sortByEditedDate()
                true
            }
            R.id.title_sorting -> {
                viewModel.sortByTitle()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}