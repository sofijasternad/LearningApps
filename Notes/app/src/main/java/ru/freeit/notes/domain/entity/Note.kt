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
    fun tags() = tags
    fun id() = id
    fun title() = title
    fun lastEdited() : String {
        val calendar = Calendar.getInstance()
        calendar.time = Date(editedDate)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            .toString()
            .padStart(2, '0')
        val month = calendar.get(Calendar.MONTH)
            .toString()
            .padStart(2, '0')
        val year = calendar.get(Calendar.YEAR)
        return "$dayOfMonth.$month.$year"
    }
    fun toDb() = DbNote(title, createdDate, editedDate, id)
}