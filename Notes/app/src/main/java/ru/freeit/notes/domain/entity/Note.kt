package ru.freeit.notes.domain.entity

import ru.freeit.notes.data.db.entity.Note as DbNote

data class Note(
    private val id: Long = 0,
    private val title: String = "",
    private val createdDate: Long = System.currentTimeMillis(),
    private val editedDate: Long = System.currentTimeMillis()
) {

    fun toDb() = DbNote(title, createdDate, editedDate, id)

    // TODO дополнительная функциональность
}