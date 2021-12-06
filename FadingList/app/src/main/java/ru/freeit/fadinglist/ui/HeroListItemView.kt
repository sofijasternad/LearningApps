package ru.freeit.fadinglist.ui

import android.content.Context
import android.view.MotionEvent
import android.widget.FrameLayout
import ru.freeit.fadinglist.core.*

class HeroListItemView(ctx: Context, listenItem: (item: (pos: Int, item: Hero) -> Unit) -> Unit) : FrameLayout(ctx) {

    init {
        clickable()

        val img = imageView(ctx) {
            centerCrop()
            layoutParams(frameLayoutParams().matchWidth().height(400.dp(ctx)).params())
        }

        val fadingView = textView(ctx) {
            bgColor(rgba(0, 0, 0, .8f))
            alpha(0f)
            layoutParams(frameLayoutParams().matchWidth().matchHeight().params())
        }

        val text = textView(ctx) {
            color(white())
            textSize(20f)
            layoutParams(
                frameLayoutParams()
                    .bottomStart()
                    .marginStart(16.dp(ctx))
                    .marginBottom(16.dp(ctx))
                    .params()
            )
        }

        listenItem { _, hero ->
            hero.img(img)
            hero.title(text)
        }

        var animator = fadingView.animate()

        setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN,
                MotionEvent.ACTION_MOVE,
                MotionEvent.ACTION_HOVER_ENTER,
                MotionEvent.ACTION_HOVER_MOVE -> {
                    animator.alpha(1f).setDuration(500L).start()
                }
                else -> {
                    animator.cancel()
                    fadingView.alpha(0f)
                }
            }
            true
        }

        addView(img, text, fadingView)
    }
}