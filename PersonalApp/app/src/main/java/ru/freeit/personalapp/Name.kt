package ru.freeit.personalapp

import android.content.Context

class Name(private val ctx: Context) {

    fun str() : String {
        val nm = ctx.getString(R.string.my_name)
        val emojiPonies = "\uD83C\uDFA0".repeat(3)
        return "$nm $emojiPonies"
    }
}