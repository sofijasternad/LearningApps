package ru.freeit.hiltapp.domain.repository

import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.freeit.hiltapp.data.local.ChapterLocalDataSource
import ru.freeit.hiltapp.data.model.Chapter
import javax.inject.Inject
import javax.inject.Singleton

interface ChapterRepository {
    suspend fun chapter() : Chapter
}

class ChapterRepositoryImpl @Inject constructor(
    private val local: ChapterLocalDataSource,
    private val dispatcher: CoroutineDispatcher
) : ChapterRepository {

    override suspend fun chapter() = withContext(dispatcher) {
        local.fetchChapter()
    }

}