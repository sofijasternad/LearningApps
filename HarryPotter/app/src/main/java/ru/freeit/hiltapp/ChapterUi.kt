package ru.freeit.hiltapp

import android.widget.TextView

data class ChapterUi(private val name: String, private val content: String) {
    fun name(textView: TextView) {
        textView.text = name
    }
    fun content(textView: TextView) {
        textView.text = content
    }
}