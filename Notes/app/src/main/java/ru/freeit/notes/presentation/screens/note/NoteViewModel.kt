package ru.freeit.notes.presentation.screens.note

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlinx.coroutines.launch
import ru.freeit.notes.core.CoroutineViewModel
import ru.freeit.notes.core.LiveDataWrapper
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.domain.repository.NoteRepository

class NoteViewModel(private val noteId: Long = -1, private val repo: NoteRepository) : CoroutineViewModel() {

    private val status = LiveDataWrapper<NoteStatus>()

    init { fetchNoteById(noteId) }

    private fun fetchNoteById(noteId: Long) {
        viewModelScope.launch {
            if (noteId >= 0) {
                val note = repo.noteBy(noteId)
                status.changeValue(NoteStatus.AlreadyAdded(note))
            }
        }
    }

    fun observeStatus(owner: LifecycleOwner, observer: Observer<NoteStatus>) {
        status.observe(owner, observer)
    }

    private fun edit(title: String) {
        viewModelScope.launch {
            val note = repo.noteBy(noteId)
            repo.update(note.copy(title = title))
            status.changeValue(NoteStatus.SuccessEdited)
        }
    }

    private fun add(title: String) {
        viewModelScope.launch {
            repo.add(Note(title = title))
            status.changeValue(NoteStatus.SuccessAdded)
        }
    }

    fun apply(title: String) {
        if (title.trim().isNotEmpty()) {
            if (noteId >= 0) {
                edit(title)
            } else {
                add(title)
            }
        } else {
            status.changeValue(NoteStatus.TitleEmpty)
        }
    }

}