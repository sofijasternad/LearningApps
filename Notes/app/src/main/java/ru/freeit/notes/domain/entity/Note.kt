package ru.freeit.notes.domain.entity

import java.util.*
import ru.freeit.notes.data.db.entity.Note as DbNote

data class Note(
    private val id: Long = 0,
    private val title: String = "",
    private val createdDate: Long = System.currentTimeMillis(),
    private val editedDate: Long = System.currentTimeMillis(),
    private val tags: List<Tag> = listOf()
) {

    fun tagsString() = tags.joinToString(", ") { tag ->
        tag.title
    }
    fun id() = id
    fun title() = title
    fun lastEdited() : String {
        val calendar = Calendar.getInstance()
        calendar.time = Date(editedDate)
        return "${calendar.get(Calendar.DAY_OF_MONTH)}.${calendar.get(Calendar.MONTH)}.${calendar.get(Calendar.YEAR)}"
    }
    fun toDb() = DbNote(title, createdDate, editedDate, id)
}