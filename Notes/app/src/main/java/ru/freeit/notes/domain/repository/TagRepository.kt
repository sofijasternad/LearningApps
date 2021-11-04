package ru.freeit.notes.domain.repository

import ru.freeit.notes.domain.entity.Tag

interface TagRepository {
    suspend fun remove(tag: Tag)
    fun add(tag: Tag)
    fun tags() : List<Tag>
    suspend fun apply(noteId: Long)
}