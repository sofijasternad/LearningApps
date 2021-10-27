package ru.freeit.ponylist.model

data class Pony(
    private val id: Int = 0,
    private val title: Int,
    private val img: Int,
    private val type: Int
) {
    fun id() = id
    fun img() = img
    fun name() = title
    fun family() = type
}