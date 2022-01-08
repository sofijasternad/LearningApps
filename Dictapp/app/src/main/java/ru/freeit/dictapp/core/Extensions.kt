package ru.freeit.dictapp.core

import android.content.Context
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import kotlin.math.roundToInt

fun String.isJsonObject() : Boolean {
    return JSONTokener(this).nextValue() is JSONObject
}

fun String.toJsonArray() : JSONArray {
    return JSONArray(this)
}

fun Int.dp(ctx: Context) = (ctx.resources.displayMetrics.density * this).roundToInt()

fun EditText.onTextChange(listener: (text: String) -> Unit) {
    doOnTextChanged { text, _, _, _ ->
        listener(text?.toString() ?: "")
    }
}

fun JSONObject.str(key: String, default: String = "") : String {
    return if (has(key))  getString(key) else default
}

fun JSONArray.firstObject() : JSONObject {
    return if (length() == 0) JSONObject() else getJSONObject(0)
}


fun JSONArray.jsonObject(index: Int) : JSONObject {
    return getJSONObject(index)
}

fun JSONObject.jsonObject(key: String, default: JSONObject = JSONObject()) : JSONObject {
    return if (has(key)) getJSONObject(key) else default
}

fun JSONObject.array(key: String, default: JSONArray = JSONArray()) : JSONArray {
    return if (has(key)) getJSONArray(key) else default
}
