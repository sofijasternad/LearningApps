package ru.freeit.personalapp

import android.content.Context

/**
 * простейший класс, который формирует заголовок нашего тулбара
 */
class Name(private val ctx: Context) {

    fun str() : String {
        // сначала получаем имя из ресурсов
        val nm = ctx.getString(R.string.my_name)
        // создаем три смайлика
        val emojiPonies = "\uD83C\uDFA0".repeat(3)
        // объединяем имя со смайликами и возвращаем
        return "$nm $emojiPonies"
    }
}