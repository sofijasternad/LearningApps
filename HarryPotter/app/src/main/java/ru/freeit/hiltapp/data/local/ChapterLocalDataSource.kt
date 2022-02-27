package ru.freeit.hiltapp.data.local

import ru.freeit.hiltapp.data.model.Chapter

interface ChapterLocalDataSource {
    suspend fun fetchChapter() : Chapter
}

