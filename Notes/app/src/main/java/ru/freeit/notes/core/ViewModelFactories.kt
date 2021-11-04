package ru.freeit.notes.core

import android.os.Bundle
import androidx.savedstate.SavedStateRegistryOwner
import ru.freeit.notes.domain.repository.NoteRepository
import ru.freeit.notes.domain.repository.TagRepository
import ru.freeit.notes.presentation.screens.note.NoteViewModelFactory
import ru.freeit.notes.presentation.screens.notes.NotesViewModelFactory

class ViewModelFactories(
    private val noteRepo: NoteRepository,
    private val tagRepo: TagRepository
) {
    fun notesViewModelFactory(owner: SavedStateRegistryOwner, bundle: Bundle?) =
        NotesViewModelFactory(owner, bundle, noteRepo, tagRepo)
    fun noteViewModelFactory(noteId: Long) =
        NoteViewModelFactory(noteId, noteRepo, tagRepo)
}