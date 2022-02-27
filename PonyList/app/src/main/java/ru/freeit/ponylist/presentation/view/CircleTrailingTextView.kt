package ru.freeit.ponylist.presentation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CircleTrailingTextView @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(ctx, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = textColors.defaultColor
    }

    private fun dp(value: Int) = (context.resources.displayMetrics.density * value).toInt()
    private fun dp(value: Float) = (context.resources.displayMetrics.density * value)

    init {
        setPadding(paddingStart, paddingTop, paddingEnd + dp(5), paddingBottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(width - paddingEnd - dp(5f), height / 2f,  dp(5f), paint)
    }

}