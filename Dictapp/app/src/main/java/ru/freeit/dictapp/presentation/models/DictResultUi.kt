package ru.freeit.dictapp.presentation.models

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.widget.LinearLayoutCompat
import ru.freeit.dictapp.data.entity.DictDefinition
import ru.freeit.dictapp.presentation.view.DefinitionTextView

sealed interface DictResultUi {

    object Loading: DictResultUi

    data class Error(@StringRes private val textResId: Int): DictResultUi {
        fun text(view: TextView) {
            view.setText(textResId)
        }
    }

    data class Success(private val word: String, private val definitions: List<DictDefinition>) : DictResultUi {

        fun word(view: TextView) {
            view.text = word
        }

        fun definitions(layout: LinearLayoutCompat) {
            layout.removeAllViews()
            definitions.mapIndexed { index, definition -> definition.str(index + 1) }
                .forEach { str -> layout.addView(DefinitionTextView(layout.context, str)) }
        }

    }

}