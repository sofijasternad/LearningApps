package ru.freeit.notes.domain.entity

import java.util.*
import ru.freeit.notes.data.db.entity.Note as NoteDatabase

data class Note(
    private val id: Long = 0,
    private val title: String = "",
    private val createdDate: Long = System.currentTimeMillis(),
    private val editedDate: Long = System.currentTimeMillis(),
    private val tags: List<Tag> = listOf()
) {

    fun tagsString() = tags.joinToString(", ") { tag -> tag.title }
    fun tags() = tags

    fun id() = id
    fun title() = title

    private val Int.padded
        get() = this.toString().padStart(2, '0')

    fun lastEdited() : String {
        val calendar = Calendar.getInstance()
        calendar.time = Date(editedDate)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH).padded
        val month = calendar.get(Calendar.MONTH).padded
        val year = calendar.get(Calendar.YEAR)
        return "$dayOfMonth.$month.$year"
    }

    fun toDatabase() = NoteDatabase(title, createdDate, editedDate, id)
}