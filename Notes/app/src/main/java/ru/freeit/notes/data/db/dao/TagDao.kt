package ru.freeit.notes.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import ru.freeit.notes.data.db.entity.Tag

@Dao
interface TagDao {
    @Insert
    suspend fun add(tag: Tag)

    @Delete
    suspend fun remove(tag: Tag)
}