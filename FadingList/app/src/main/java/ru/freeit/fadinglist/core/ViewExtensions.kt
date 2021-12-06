package ru.freeit.fadinglist.core

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

// Core

fun Int.dp(ctx: Context) = (this * ctx.resources.displayMetrics.density).roundToInt()

fun View.clickable() {
    isClickable = true
}

fun View.alpha(a: Float) {
    alpha = a
}

fun View.scaleX(scale: Float) {
    scaleX = scale
}

fun View.scale(scX: Float = 1f, scY: Float = 1f) {
    scaleX = scX
    scaleY = scY
}

fun View.scaleY(scale: Float) {
    scaleY = scale
}

fun View.gone() {
    isVisible = false
}

fun View.onClick(listener: () -> Unit) {
    setOnClickListener { listener() }
}

fun View.white() = Color.WHITE
fun View.black() = Color.BLACK

fun View.padding(start: Int = paddingStart, top: Int = paddingTop, end: Int = paddingEnd, bottom: Int = paddingBottom) {
    setPadding(start, top, end, bottom)
}

fun View.padding(horizontal: Int, vertical: Int) {
    setPadding(horizontal, vertical, horizontal, vertical)
}

fun View.padding(all: Int) {
    setPadding(all, all, all, all)
}

fun View.layoutParams(params: ViewGroup.LayoutParams) {
    layoutParams = params
}

fun ViewGroup.addView(vararg view: View) {
    view.forEach { view ->
        addView(view)
    }
}

fun View.defaultRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

// FrameLayout

fun frameLayout(ctx: Context, builder: FrameLayout.() -> Unit) : FrameLayout {
    val frame = FrameLayout(ctx)
    builder(frame)
    return frame
}

// LinearLayout

fun LinearLayoutCompat.centerVertical() {
    gravity = Gravity.CENTER_VERTICAL
}

fun LinearLayoutCompat.centerHorizontal() {
    gravity = Gravity.CENTER_HORIZONTAL
}

fun LinearLayoutCompat.horizontal() {
    orientation = LinearLayoutCompat.HORIZONTAL
}

fun LinearLayoutCompat.vertical() {
    orientation = LinearLayoutCompat.VERTICAL
}

// TextView

fun textView(context: Context, init: AppCompatTextView.() -> Unit) : AppCompatTextView {
    val text = AppCompatTextView(context)
    text.init()
    return text
}

fun AppCompatTextView.stringRes(@StringRes res: Int) {
    setText(res)
}

fun AppCompatTextView.textSize(sp: Float) {
    setTextSize(TypedValue.COMPLEX_UNIT_SP, sp)
}

fun AppCompatTextView.bg(bg: Drawable) {
    background = bg
}

fun AppCompatTextView.bgColor(color: Int) {
    setBackgroundColor(color)
}

fun rgba(red: Int, green: Int, blue: Int, alpha: Float) : Int {
    return Color.argb((alpha * 255).roundToInt(), red, green, blue)
}

fun AppCompatTextView.textCenter() {
    textAlignment = View.TEXT_ALIGNMENT_CENTER
}

fun TextView.color(color: Int) {
    setTextColor(color)
}

fun <T> TextView.text(value: T) {
    text = value.toString()
}

// ImageView

fun AppCompatImageView.bg(@DrawableRes res: Int) {
    setBackgroundResource(res)
}

fun AppCompatImageView.src(@DrawableRes res: Int) {
    setImageResource(res)
}

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

fun listView(ctx: Context, init: RecyclerView.() -> Unit) : RecyclerView {
    val list = RecyclerView(ctx)
    list.init()
    return list
}

fun <T> RecyclerView.adapter(items: List<T>, viewHolder: ViewHolderWrapper<T>) {
    adapter = CoreAdapter(items, viewHolder)
}
