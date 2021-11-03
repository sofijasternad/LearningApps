package ru.freeit.notes.data.db.dao

import androidx.room.*
import ru.freeit.notes.data.db.entity.Note

@Dao
interface NoteDao {

    @Query("select * from notes order by created_date")
    suspend fun notesByCreatedDate() : List<Note>

    @Query("select * from notes order by edited_date")
    suspend fun notesByEditedDate() : List<Note>

    @Query("select * from notes order by title")
    suspend fun notesByTitle() : List<Note>

    @Query("select * from notes")
    suspend fun notes() : List<Note>

    @Query("select * from notes where id = :id")
    suspend fun noteBy(id: Long) : Note

    @Insert
    suspend fun add(note: Note)

    @Delete
    suspend fun remove(note: Note)

    @Update
    suspend fun update(note: Note)

}