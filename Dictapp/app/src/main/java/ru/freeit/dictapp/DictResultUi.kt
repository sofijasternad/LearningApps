package ru.freeit.dictapp

import android.util.TypedValue
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import ru.freeit.dictapp.core.dp

sealed class DictResultUi {
    object Loading: DictResultUi()
    data class Error(@StringRes private val textResId: Int): DictResultUi()
    data class Success(private val word: String, private val definitions: List<DictDefinition>) : DictResultUi() {

        fun word(view: TextView) {
            view.text = word
        }

        fun definitions(layout: LinearLayoutCompat) {
            definitions.mapIndexed { index, definition -> "$index. ${definition.str()}" }
                .forEach { str ->
                    layout.addView(AppCompatTextView(layout.context).apply {
                        text = str
                        setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                        setTextColor(ContextCompat.getColor(context, R.color.grey_300))
                        layoutParams = LinearLayoutCompat.LayoutParams(
                            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                            LinearLayoutCompat.LayoutParams.WRAP_CONTENT
                        ).apply {
                            bottomMargin = 8.dp(context)
                        }
                    })
                }
        }

    }
}