package ru.freeit.hiltapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Chapter(
    @SerialName(value = "chapter_name")
    val name: String,
    @SerialName(value = "chapter_text")
    val text: String
) {
}