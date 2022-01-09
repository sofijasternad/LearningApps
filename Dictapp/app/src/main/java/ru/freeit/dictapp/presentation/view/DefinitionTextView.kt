package ru.freeit.dictapp.presentation.view

import android.content.Context
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import ru.freeit.dictapp.R
import ru.freeit.dictapp.core.dp

class DefinitionTextView(ctx: Context, str: CharSequence) : AppCompatTextView(ctx) {
    init {
        text = str
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        setTextColor(ContextCompat.getColor(context, R.color.grey_300))
        layoutParams = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        ).apply {
            bottomMargin = 8.dp(context)
        }
    }
}