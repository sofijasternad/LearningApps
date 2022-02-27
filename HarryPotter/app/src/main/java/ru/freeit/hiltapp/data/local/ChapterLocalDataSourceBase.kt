package ru.freeit.hiltapp.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.freeit.hiltapp.data.model.Chapter
import javax.inject.Inject

class ChapterLocalDataSourceBase @Inject constructor(@ApplicationContext ctx: Context) :
    ChapterLocalDataSource {

    private val assetManager = ctx.assets

    override suspend fun fetchChapter(): Chapter {
        val jsonString = assetManager.open(potterFileName).bufferedReader().use { reader -> reader.readText() }
        return Json.decodeFromString<List<Chapter>>(jsonString).first()
    }

    companion object {
        private const val potterFileName = "potter5.json"
    }

}