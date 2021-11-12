package ru.freeit.hiltapp.data.local

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.freeit.hiltapp.data.model.Chapter
import java.io.File
import java.lang.StringBuilder

interface ChapterLocalDataSource {
    suspend fun fetchChapter() : Chapter

    class Base(private val ctx: Context) : ChapterLocalDataSource {

        override suspend fun fetchChapter(): Chapter {
            val jsonString = ctx.assets.open("potter5.json").bufferedReader().use { reader ->
                val buffer = StringBuilder()
                var line = reader.readLine()
                while (line != null) {
                    buffer.append(line)
                    line = reader.readLine()
                }
                buffer.toString()
            }
            return Json.decodeFromString<List<Chapter>>(jsonString).first()
        }

    }
}