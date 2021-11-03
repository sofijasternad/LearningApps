package ru.freeit.notes.domain.repository

import ru.freeit.notes.domain.entity.Note

enum class SortingType {
    CREATED_DATE, EDITED_DATE, TITLE
}

interface NoteRepository {
    suspend fun notesBy(sortingType: SortingType = SortingType.TITLE) : List<Note>
    suspend fun add(note: Note)
    suspend fun remove(note: Note)
    suspend fun update(note: Note)
}