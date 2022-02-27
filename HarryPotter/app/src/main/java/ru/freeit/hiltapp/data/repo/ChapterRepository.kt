package ru.freeit.hiltapp.data.repo

import ru.freeit.hiltapp.data.model.Chapter

interface ChapterRepository {
    suspend fun chapter() : Chapter
}

