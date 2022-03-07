package ru.freeit.notes.presentation.screens.notes

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.core.FragmentManagerWrapper
import ru.freeit.notes.databinding.NotesScreenBinding
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.presentation.MainActivity
import ru.freeit.notes.presentation.screens.note.NoteScreen


class NotesScreen : Fragment() {

    private var viewModel: NotesViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NotesScreenBinding.inflate(inflater)

        val viewModelFactory = (requireContext().applicationContext as App).viewModelFactories
            .notesViewModelFactory(this, savedInstanceState)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(NotesViewModel::class.java)
        this.viewModel = viewModel

        val fragmentManagerWrapper = FragmentManagerWrapper(parentFragmentManager)

        val clipboardService = requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        val adapter = NotesAdapter(object: NoteListItemCallback {
            override fun remove(note: Note) = viewModel.remove(note)
            override fun edit(note: Note) = fragmentManagerWrapper.replace(NoteScreen.newInstance(note.id()))
            override fun copyClipboard(title: String) {
                val clipData = ClipData.newPlainText(getString(R.string.note), title)
                clipboardService.setPrimaryClip(clipData)
                Snackbar.make(binding.root, R.string.copy_success, Snackbar.LENGTH_SHORT).show()
            }
        })

        binding.noteList.adapter = adapter

        viewModel.init()
        viewModel.observeNotes(viewLifecycleOwner, adapter::submitList)

        binding.addNoteButton.setOnClickListener {
            fragmentManagerWrapper.replaceWithAnim(
                NoteScreen(),
                R.anim.fade_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.fade_out
            )
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
                viewModel?.sortDefault()
                true
            }
            R.id.create_date_sorting -> {
                viewModel?.sortByCreatedDate()
                true
            }
            R.id.edited_date_sorting -> {
                viewModel?.sortByEditedDate()
                true
            }
            R.id.title_sorting -> {
                viewModel?.sortByTitle()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel = null
    }
}