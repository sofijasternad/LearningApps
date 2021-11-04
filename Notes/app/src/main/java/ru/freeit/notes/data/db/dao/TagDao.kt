package ru.freeit.notes.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.freeit.notes.data.db.entity.Tag

@Dao
interface TagDao {
    @Insert
    suspend fun add(tag: Tag)

    @Delete
    suspend fun remove(tag: Tag)

    @Query("delete from tags where note_id = :noteId")
    suspend fun removeBy(noteId: Long)
}