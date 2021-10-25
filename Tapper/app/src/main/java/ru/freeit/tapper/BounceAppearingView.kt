package ru.freeit.tapper

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import kotlin.random.Random

class BounceAppearingView @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(ctx, attrs, defStyleAttr) {

    private var points = mutableListOf<Pair<Int, Int>>()
    private var initialRadius = 0
    private val maxRadius = 30

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.purple_500)
    }

    fun appear() {

        points.clear()

        for (i in 0 until 10) {
            val x = Random.nextInt(width)
            val y = Random.nextInt(height)
            points.add(x to y)
        }

        ValueAnimator.ofInt(0, maxRadius).apply {
            duration = 300L
            addUpdateListener {
                initialRadius = it.animatedValue as Int
                invalidate()
            }
            start()
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (point in points) {
            canvas.drawCircle(
                point.first * 1f,
                point.second * 1f,
                initialRadius * 1f, paint
            )
        }
    }

}