package ru.freeit.notes.presentation.screens.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.freeit.notes.domain.repository.NoteRepository

class NoteViewModelFactory(private val repo: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(repo) as T
    }
}