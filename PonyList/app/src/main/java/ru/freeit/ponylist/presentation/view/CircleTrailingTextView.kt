package ru.freeit.ponylist.presentation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CircleTrailingTextView @JvmOverloads constructor(ctx: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(ctx, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = textColors.defaultColor
    }

    private fun Int.dp() = (context.resources.displayMetrics.density * this).toInt()

    init {
        setPadding(paddingStart, paddingTop, paddingEnd + 10.dp(), paddingBottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width - paddingEnd - 5.dp() - 0f, height / 2f, 5.dp() * 1f, paint)
    }

}