package ru.freeit.notes.presentation.screens.notes

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.launch
import ru.freeit.notes.core.CoroutineViewModel
import ru.freeit.notes.core.LiveDataWrapper
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.domain.repository.NoteRepository
import ru.freeit.notes.domain.repository.SortingType

class NotesViewModel(
    private val repo: NoteRepository,
    private val savedStateHandle: SavedStateHandle
) : CoroutineViewModel() {

    private val notes = LiveDataWrapper<List<Note>>()
    private var sortingType = SortingType.TITLE

    private val sortingKey = "sorting_key"

    fun observeNotes(owner: LifecycleOwner, observer: Observer<List<Note>>) {
        notes.observe(owner, observer)
    }

    fun remove(note: Note) {
        viewModelScope.launch {
            repo.remove(note)
            notes.changeValue(repo.notesBy(sortingType))
        }
    }

    fun init() {
        val sortingName = savedStateHandle[sortingKey] ?: SortingType.NO_SORTING.name
        sortingType = SortingType.valueOf(sortingName)
        fetchNotes()
    }

    fun sortDefault() {
        sortingType = SortingType.NO_SORTING
        fetchNotes()
    }

    fun sortByTitle() {
        sortingType = SortingType.TITLE
        fetchNotes()
    }

    fun sortByEditedDate() {
        sortingType = SortingType.EDITED_DATE
        fetchNotes()
    }

    fun sortByCreatedDate() {
        sortingType = SortingType.CREATED_DATE
        fetchNotes()
    }

    private fun fetchNotes() {
        viewModelScope.launch {
            savedStateHandle[sortingKey] = sortingType.name
            notes.changeValue(repo.notesBy(sortingType))
        }
    }

}