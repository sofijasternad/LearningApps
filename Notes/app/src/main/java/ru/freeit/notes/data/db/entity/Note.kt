package ru.freeit.notes.data.db.entity

import ru.freeit.notes.domain.entity.Note as DomainNote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "notes")
data class Note(
    val title: String = "",
    @ColumnInfo(name = "created_date")
    val createdDate: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "edited_date")
    val editedDate: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
) {

    fun toDomain() = DomainNote(id, title, createdDate, editedDate)
}