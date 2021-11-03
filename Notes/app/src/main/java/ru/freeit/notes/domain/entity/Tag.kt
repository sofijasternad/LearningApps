package ru.freeit.notes.domain.entity

import ru.freeit.notes.data.db.entity.Tag as DbTag

data class Tag(
    val id: Long,
    val title: String,
    val noteId: Long,
) {
    fun title() = title

    fun toDb() = DbTag(title, noteId, id)
}