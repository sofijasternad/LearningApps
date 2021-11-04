package ru.freeit.notes.presentation.screens.notes

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import ru.freeit.notes.domain.repository.NoteRepository
import ru.freeit.notes.domain.repository.TagRepository

class NotesViewModelFactory(
    private val owner: SavedStateRegistryOwner,
    private val bundle: Bundle?,
    private val noteRepo: NoteRepository,
    private val tagRepo: TagRepository
) : AbstractSavedStateViewModelFactory(owner, bundle) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return NotesViewModel(noteRepo, tagRepo, handle) as T
    }
}