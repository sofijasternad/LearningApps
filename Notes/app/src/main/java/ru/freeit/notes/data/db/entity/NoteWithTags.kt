package ru.freeit.notes.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class NoteWithTags(
    @Embedded val note: Note,
    @Relation(
        parentColumn = "id",
        entityColumn = "noteId"
    )
    val tags: List<Tag>
) {
    fun toDomain() = note.toDomain().copy(tags = tags.map { tag -> tag.toDomain() })
}