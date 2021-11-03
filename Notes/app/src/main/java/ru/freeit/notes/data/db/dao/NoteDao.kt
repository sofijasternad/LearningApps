package ru.freeit.notes.data.db.dao

import androidx.room.*
import ru.freeit.notes.data.db.entity.Note

@Dao
interface NoteDao {

    @Query("select * from notes order by created_date")
    fun notesByCreatedDate() : List<Note>

    @Query("select * from notes order by edited_date")
    fun notesByEditedDate() : List<Note>

    @Query("select * from notes order by title")
    fun notesByTitle() : List<Note>

    @Insert
    fun add(note: Note)

    @Delete
    fun remove(note: Note)

    @Update
    fun update(note: Note)

}