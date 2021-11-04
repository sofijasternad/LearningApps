package ru.freeit.notes.presentation.screens.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.freeit.notes.domain.repository.NoteRepository
import ru.freeit.notes.domain.repository.TagRepository

class NoteViewModelFactory(
    private val noteId: Long = -1,
    private val noteRepo: NoteRepository,
    private val tagsRepo: TagRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(noteId, noteRepo, tagsRepo) as T
    }
}