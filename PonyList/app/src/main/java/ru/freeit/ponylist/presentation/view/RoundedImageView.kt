package ru.freeit.ponylist.presentation.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

class RoundedImageView @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(ctx, attrs, defStyleAttr) {

    private fun Int.dp() = context.resources.displayMetrics.density * this

    override fun draw(canvas: Canvas) {

        val path = Path().apply {
            val rectF = RectF(0f, 0f, width.toFloat(), height.toFloat())
            val radius = 50.dp()
            addRoundRect(rectF, radius, radius, Path.Direction.CW)
        }

        canvas.clipPath(path)

        super.draw(canvas)
    }

}