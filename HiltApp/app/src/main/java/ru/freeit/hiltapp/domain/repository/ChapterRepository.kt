package ru.freeit.hiltapp.domain.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.freeit.hiltapp.data.local.ChapterLocalDataSource
import ru.freeit.hiltapp.data.model.Chapter

class ChapterRepository(
    private val local: ChapterLocalDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun chapter() = withContext(dispatcher) {
        local.fetchChapter()
    }

}