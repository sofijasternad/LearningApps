package ru.freeit.notes.presentation.screens.notes

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.domain.repository.NoteRepository

class NotesViewModelFactory(
    private val owner: SavedStateRegistryOwner,
    private val bundle: Bundle?,
    private val repo: NoteRepository
) : AbstractSavedStateViewModelFactory(owner, bundle) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return NotesViewModel(repo, handle) as T
    }
}