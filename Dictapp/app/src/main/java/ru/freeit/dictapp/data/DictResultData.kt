package ru.freeit.dictapp.data

import androidx.annotation.StringRes
import ru.freeit.dictapp.ui.DictResultUi
import ru.freeit.dictapp.R
import ru.freeit.dictapp.core.*

sealed class DictResultData {

    abstract fun toUi() : DictResultUi

    data class Success(private val word: String, private val definitions: List<DictDefinition>) : DictResultData() {
        override fun toUi(): DictResultUi {
            return DictResultUi.Success(word, definitions)
        }
    }

    data class Error(@StringRes private val resId: Int) : DictResultData() {
        override fun toUi(): DictResultUi {
            return DictResultUi.Error(resId)
        }
    }

    companion object {
        fun fromJson(json: String) : DictResultData {

            if (json.isJsonObject()) {
                return Error(R.string.nothing_found)
            }

            val jsonObject = json.toJsonArray().firstObject()

            val word = jsonObject.str("word")
            val jsonDefinitions = jsonObject.array("meanings")
                .firstObject()
                .array("definitions")

            val definitions = mutableListOf<DictDefinition>()

            for (i in 0 until jsonDefinitions.length()) {

                val jsonDefinition = jsonDefinitions.jsonObject(i)

                val definition = jsonDefinition.str("definition")
                val example = jsonDefinition.str("example")

                definitions.add(DictDefinition(definition, example))
            }

            return Success(word, definitions)
        }
    }

}