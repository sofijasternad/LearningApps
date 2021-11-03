package ru.freeit.notes.presentation.screens.notes

import kotlinx.coroutines.launch
import ru.freeit.notes.core.CoroutineViewModel
import ru.freeit.notes.core.LiveDataWrapper
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.domain.entity.Note

class NotesViewModel(private val database: AppDatabase) : CoroutineViewModel() {

    private val notes = LiveDataWrapper<List<Note>>()

    fun init() {
        viewModelScope.launch {

        }
    }
}