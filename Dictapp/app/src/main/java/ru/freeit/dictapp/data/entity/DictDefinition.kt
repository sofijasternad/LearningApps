package ru.freeit.dictapp.data.entity

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan

data class DictDefinition(private val definition: String, private val example: String) {
    fun str(number: Int) : CharSequence {
        if (example.isEmpty()) {
            return definition
        }

        val text = "$number. $definition\n\n$example"
        return SpannableString(text).apply {
            val exampleIndex = text.indexOf(example)

            setSpan(ForegroundColorSpan(Color.rgb(120, 120, 120)), exampleIndex, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(0.9f), exampleIndex, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }
}