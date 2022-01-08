package ru.freeit.dictapp

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan

data class DictDefinition(private val definition: String, private val example: String) {
    fun str() : CharSequence {
        if (example.isEmpty()) {
            return definition
        }

        val text = "$definition\n\n$example"
        return SpannableString(text).apply {
            val exampleIndex = text.indexOf(example)
            setSpan(ForegroundColorSpan(Color.GREEN), exampleIndex, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(0.8f), exampleIndex, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }
}