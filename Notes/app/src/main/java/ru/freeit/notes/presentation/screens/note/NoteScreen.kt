package ru.freeit.notes.presentation.screens.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.launch
import ru.freeit.notes.R
import ru.freeit.notes.core.App
import ru.freeit.notes.core.CoroutineViewModel
import ru.freeit.notes.core.LiveDataWrapper
import ru.freeit.notes.databinding.NoteScreenBinding
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.domain.repository.NoteRepository

enum class AddNoteStatus {
    SUCCESS_ADDED,
    EMPTY_TITLE
}

class NoteViewModelFactory(private val repo: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(repo) as T
    }
}

class NoteViewModel(private val repo: NoteRepository) : CoroutineViewModel() {

    private val status = LiveDataWrapper<AddNoteStatus>()

    fun observeStatus(owner: LifecycleOwner, observer: Observer<AddNoteStatus>) {
        status.observe(owner, observer)
    }

    private fun add(title: String) {
        viewModelScope.launch {
            repo.add(Note(title = title))
            status.changeValue(AddNoteStatus.SUCCESS_ADDED)
        }
    }

    fun apply(title: String) {
        if (title.trim().isNotEmpty()) {
            add(title)
        } else {
            status.changeValue(AddNoteStatus.EMPTY_TITLE)
        }
    }

}

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