package ru.freeit.notes.presentation.screens.note

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlinx.coroutines.launch
import ru.freeit.notes.core.CoroutineViewModel
import ru.freeit.notes.core.LiveDataWrapper
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.domain.repository.NoteRepository

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