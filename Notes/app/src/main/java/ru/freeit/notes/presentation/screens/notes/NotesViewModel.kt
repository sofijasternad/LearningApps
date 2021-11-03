package ru.freeit.notes.presentation.screens.notes

import ru.freeit.notes.core.LiveDataWrapper
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.domain.entity.Note

class NotesViewModel(private val database: AppDatabase) {

    private val notes = LiveDataWrapper<List<Note>>()

    fun init() {

    }
}