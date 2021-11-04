package ru.freeit.notes.presentation.screens.note

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlinx.coroutines.launch
import ru.freeit.notes.core.CoroutineViewModel
import ru.freeit.notes.core.LiveDataWrapper
import ru.freeit.notes.domain.entity.Note
import ru.freeit.notes.domain.entity.Tag
import ru.freeit.notes.domain.repository.NoteRepository
import ru.freeit.notes.domain.repository.TagRepository

class NoteViewModel(
    private val noteId: Long = -1,
    private val noteRepo: NoteRepository,
    private val tagRepo: TagRepository
) : CoroutineViewModel() {

    private val status = LiveDataWrapper<NoteStatus>()
    private val tags = LiveDataWrapper<List<Tag>>()

    init { fetchNoteById(noteId) }

    private fun fetchNoteById(noteId: Long) {
        viewModelScope.launch {
            if (noteId >= 0) {
                val note = noteRepo.noteBy(noteId)
                tags.changeValue(note.tags() + tagRepo.tags())
                status.changeValue(NoteStatus.AlreadyAdded(note))
            }
        }
    }

    fun observeTags(owner: LifecycleOwner, observer: Observer<List<Tag>>) = tags.observe(owner, observer)
    fun observeStatus(owner: LifecycleOwner, observer: Observer<NoteStatus>) = status.observe(owner, observer)

    fun addTag(title: String) {
        val newTag = Tag(title)
        tagRepo.add(newTag)
        changeTags { tags -> tags.add(newTag) }
    }

    fun removeTag(tag: Tag) = viewModelScope.launch {
        tagRepo.remove(tag)
        changeTags { tags -> tags.remove(tag) }
    }

    private fun changeTags(onChange: (tags: MutableList<Tag>) -> Unit) {
        val lastTags = tags.value()?.toMutableList() ?: mutableListOf()
        onChange(lastTags)
        tags.changeValue(lastTags)
    }

    private fun edit(title: String) {
        viewModelScope.launch {
            val note = noteRepo.noteBy(noteId)
            noteRepo.update(note.copy(title = title, editedDate = System.currentTimeMillis()))
            tagRepo.apply(noteId)
            status.changeValue(NoteStatus.SuccessEdited)
        }
    }

    private fun add(title: String) {
        viewModelScope.launch {
            val noteId = noteRepo.add(Note(title = title))
            tagRepo.apply(noteId)
            status.changeValue(NoteStatus.SuccessAdded)
        }
    }

    fun apply(title: String) {
        if (title.trim().isNotEmpty()) {
            if (noteId >= 0) {
                edit(title)
            } else {
                add(title)
            }
        } else {
            status.changeValue(NoteStatus.TitleEmpty)
        }
    }

}