package ru.freeit.notes.domain.repository

import ru.freeit.notes.domain.entity.Tag

interface TagRepository {
    fun remove(tag: Tag)
    fun add(tag: Tag)
    fun tags() : List<Tag>
    fun clear()
    suspend fun removeBy(noteId: Long)
    suspend fun apply(noteId: Long)
}