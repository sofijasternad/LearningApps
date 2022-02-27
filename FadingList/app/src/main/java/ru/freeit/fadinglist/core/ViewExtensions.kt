package ru.freeit.fadinglist.core

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.fadinglist.core.adapter.CoreAdapter
import ru.freeit.fadinglist.core.adapter.ViewHolderWrapper
import kotlin.math.roundToInt

// Core

fun View.dp(int: Int) = (int * resources.displayMetrics.density).roundToInt()

fun View.clickable() {
    isClickable = true
}

fun View.alpha(a: Float) {
    alpha = a
}

fun View.layoutParams(params: ViewGroup.LayoutParams) {
    layoutParams = params
}

fun ViewGroup.addView(vararg view: View) {
    view.forEach { view ->
        addView(view)
    }
}


// FrameLayout

fun Activity.frameLayout(builder: FrameLayout.() -> Unit = {}) : FrameLayout {
    val frame = FrameLayout(this)
    builder(frame)
    return frame
}

// TextView

fun textView(context: Context, init: AppCompatTextView.() -> Unit) : AppCompatTextView {
    val text = AppCompatTextView(context)
    text.init()
    return text
}

fun AppCompatTextView.textSize(sp: Float) {
    setTextSize(TypedValue.COMPLEX_UNIT_SP, sp)
}


fun AppCompatTextView.bgColor(color: Int) {
    setBackgroundColor(color)
}

fun rgba(red: Int, green: Int, blue: Int, alpha: Float) : Int {
    return Color.argb((alpha * 255).roundToInt(), red, green, blue)
}

fun AppCompatTextView.colorRes(@ColorRes colorRes: Int) {
    setTextColor(ContextCompat.getColor(context, colorRes))
}

// ImageView
fun AppCompatImageView.centerCrop() {
    scaleType = ImageView.ScaleType.CENTER_CROP
}

fun imageView(context: Context, init: AppCompatImageView.() -> Unit) : AppCompatImageView {
    val img = AppCompatImageView(context)
    img.init()
    return img
}

// RecyclerView

fun RecyclerView.linearVertical(reverse: Boolean = false) {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, reverse)
}

fun Activity.list(init: RecyclerView.() -> Unit) : RecyclerView {
    val list = RecyclerView(this)
    list.init()
    return list
}

fun <T> RecyclerView.adapter(items: List<T>, viewHolder: ViewHolderWrapper<T>) {
    adapter = CoreAdapter(items, viewHolder)
}
