package ru.freeit.notes.presentation.screens.notes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.core.FragmentManagerWrapper
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

        val noteRepo = (requireContext().applicationContext as App).noteRepo
        val tagRepo = (requireContext().applicationContext as App).tagRepo
        viewModel = ViewModelProvider(this, NotesViewModelFactory(this, savedInstanceState, noteRepo, tagRepo))
            .get(NotesViewModel::class.java)

        val fragmentManagerWrapper = FragmentManagerWrapper(parentFragmentManager)

        val adapter = NotesAdapter(object: NoteListItemCallback {
            override fun remove(note: Note) = viewModel.remove(note)
            override fun edit(note: Note) = fragmentManagerWrapper.replace(NoteScreen.newInstance(note.id()))
        })

        binding.noteList.adapter = adapter

        viewModel.init()
        viewModel.observeNotes(viewLifecycleOwner, adapter::submitList)

        binding.addNoteButton.setOnClickListener { fragmentManagerWrapper.replace(NoteScreen()) }

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