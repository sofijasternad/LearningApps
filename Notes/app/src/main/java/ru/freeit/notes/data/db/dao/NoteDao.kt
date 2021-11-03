package ru.freeit.notes.data.db.dao

import androidx.room.*
import ru.freeit.notes.data.db.entity.Note
import ru.freeit.notes.data.db.entity.NoteWithTags

@Dao
interface NoteDao {

    @Transaction
    @Query("select * from notes order by created_date")
    suspend fun notesByCreatedDate() : List<NoteWithTags>

    @Transaction
    @Query("select * from notes order by edited_date")
    suspend fun notesByEditedDate() : List<NoteWithTags>

    @Transaction
    @Query("select * from notes order by title")
    suspend fun notesByTitle() : List<NoteWithTags>

    @Transaction
    @Query("select * from notes")
    suspend fun notes() : List<NoteWithTags>

    @Transaction
    @Query("select * from notes where id = :id")
    suspend fun noteBy(id: Long) : NoteWithTags

    @Insert
    suspend fun add(note: Note)

    @Delete
    suspend fun remove(note: Note)

    @Update
    suspend fun update(note: Note)

}