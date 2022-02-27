package ru.freeit.hiltapp.data.repo

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.freeit.hiltapp.data.local.ChapterLocalDataSource
import javax.inject.Inject

class ChapterRepositoryBase @Inject constructor(
    private val local: ChapterLocalDataSource,
    private val dispatcher: CoroutineDispatcher
) : ChapterRepository {

    override suspend fun chapter() = withContext(dispatcher) {
        local.fetchChapter()
    }

}