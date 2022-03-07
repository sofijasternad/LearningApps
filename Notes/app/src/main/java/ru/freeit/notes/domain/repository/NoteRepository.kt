package ru.freeit.notes.domain.repository

import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.domain.entity.SortingType

interface NoteRepository {
    suspend fun notesBy(sortingType: SortingType = SortingType.TITLE) : List<Note>
    suspend fun add(note: Note) : Long
    suspend fun noteBy(noteId: Long) : Note
    suspend fun remove(note: Note)
    suspend fun update(note: Note)
}