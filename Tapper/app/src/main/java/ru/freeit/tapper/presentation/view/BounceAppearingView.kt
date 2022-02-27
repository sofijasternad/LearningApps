package ru.freeit.tapper.presentation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import ru.freeit.tapper.R
import ru.freeit.tapper.core.changedColorAlpha
import ru.freeit.tapper.presentation.anim.PercentAnimator
import kotlin.random.Random

class BounceAppearingView @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(ctx, attrs, defStyleAttr) {

    private class Bounce(
        private val x: Int,
        private val y: Int,
        private val maxRadius: Int,
        private val alpha: Int = 100
    ) {
        fun draw(canvas: Canvas, paint: Paint, radiusPercent: Int, alphaPercent: Int) {
            val newColor = paint.color.changedColorAlpha((alpha * (alphaPercent / 100f)).toInt())
            canvas.drawCircle(x * 1f, y * 1f, maxRadius * (radiusPercent / 100f), paint.apply {
                color = newColor
            })
        }
    }

    private var points = mutableListOf<Bounce>()
    private var alphaPercent = 100
    private var radiusPercent = 0

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.purple_500)
    }

    private fun regeneratePoints() {
        points.clear()

        for (i in 0 until 50) {
            val x = Random.nextInt(width)
            val y = Random.nextInt(height)
            val maxRadius = 40 + Random.nextInt(100)
            points.add(Bounce(x, y, maxRadius, Random.nextInt(50, 120)))
        }
    }

    fun appear() {

        regeneratePoints()

        PercentAnimator().let { animator ->
            animator.animToHigh(300, onUpdate = {
                radiusPercent = it.animatedValue as Int
                invalidate()
            }, onEnd = {
                animator.animToLow(200, onUpdate = {
                    alphaPercent = it.animatedValue as Int
                    invalidate()
                }, onEnd = {
                    radiusPercent = 0
                    alphaPercent = 100
                })
            })
        }

    }

    override fun onDraw(canvas: Canvas) {
        for (point in points) {
            point.draw(canvas, paint, radiusPercent, alphaPercent)
        }
    }

}