package ru.freeit.notes.data.db.entity

import ru.freeit.notes.domain.entity.Tag as DomainTag

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class Tag(
    val title: String,
    val noteId: Long,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
) {
    fun toDomain() = DomainTag(title, noteId)
}