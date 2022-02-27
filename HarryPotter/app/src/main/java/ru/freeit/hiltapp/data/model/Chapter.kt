package ru.freeit.hiltapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.freeit.hiltapp.ChapterUi

@Serializable
data class Chapter(
    @SerialName(value = "chapter_name")
    val name: String,
    @SerialName(value = "chapter_text")
    val text: String
) {
    fun ui() = ChapterUi(name, text)
}