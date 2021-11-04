package ru.freeit.notes.domain.entity

import ru.freeit.notes.data.db.entity.Tag as DbTag

data class Tag(
    val title: String,
    val noteId: Long = -1L,
) {
    fun isBoundedToNote() = noteId >= 0
    fun title() = title
    fun toDb() = DbTag(title, noteId)
}