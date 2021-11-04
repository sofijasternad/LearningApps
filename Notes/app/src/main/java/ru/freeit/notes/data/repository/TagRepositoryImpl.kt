package ru.freeit.notes.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.domain.entity.Tag
import ru.freeit.notes.domain.repository.TagRepository

class TagRepositoryImpl(
    database: AppDatabase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : TagRepository {

    private val tagDao = database.tagDao()

    private val tagsToBeAdded = mutableListOf<Tag>()

    override suspend fun remove(tag: Tag) = withContext<Unit>(dispatcher) {
        if (tag.isBoundedToNote()) {
            tagDao.remove(tag.toDb())
        } else {
            tagsToBeAdded.remove(tag)
        }
    }

    override fun add(tag: Tag) { tagsToBeAdded.add(tag) }
    override fun tags() = tagsToBeAdded

    override suspend fun apply(noteId: Long) = withContext(dispatcher) {
        tagsToBeAdded.forEach { tag -> tagDao.add(tag.copy(noteId = noteId).toDb()) }
    }

}