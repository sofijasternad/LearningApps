package ru.freeit.notes.data.repository

import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.domain.repository.NoteRepository
import ru.freeit.notes.domain.repository.SortingType

class NoteRepositoryImpl(appDatabase: AppDatabase) : NoteRepository {

    private val noteDao = appDatabase.noteDao()

    override suspend fun notesBy(sortingType: SortingType): List<Note> {
        val dbNotes =  when (sortingType) {
            SortingType.TITLE -> {
                noteDao.notesByTitle()
            }
            SortingType.CREATED_DATE -> {
                noteDao.notesByCreatedDate()
            }
            SortingType.EDITED_DATE -> {
                noteDao.notesByEditedDate()
            }
        }
        return dbNotes.map { note -> note.toDomain() }
    }

    override suspend fun add(note: Note) = noteDao.add(note.toDb())
    override suspend fun remove(note: Note) = noteDao.remove(note.toDb())
    override suspend fun update(note: Note) = noteDao.update(note.toDb())
}