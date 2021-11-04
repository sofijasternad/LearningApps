package ru.freeit.notes.presentation.screens.note

import ru.freeit.notes.domain.entity.Note

sealed class NoteStatus {
    object SuccessAdded : NoteStatus()
    object SuccessEdited : NoteStatus()
    object TitleEmpty : NoteStatus()
    data class AlreadyAdded(private val note: Note) : NoteStatus() {
        fun title() = note.title()
    }
}