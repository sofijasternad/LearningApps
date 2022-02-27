package ru.freeit.fadinglist.ui

import android.content.Context
import android.view.MotionEvent
import android.widget.FrameLayout
import ru.freeit.fadinglist.R
import ru.freeit.fadinglist.core.*

class HeroListItemView(ctx: Context, listenItem: (item: (pos: Int, item: Hero) -> Unit) -> Unit) : FrameLayout(ctx) {

    init {
        clickable()

        val img = imageView(ctx) {
            centerCrop()
            layoutParams(frameLayoutParams().matchWidth()
                .height(dp(400)).params())
        }

        val fadingView = textView(ctx) {
            bgColor(rgba(0, 0, 0, .8f))
            alpha(0f)
            layoutParams(frameLayoutParams().matchWidth().matchHeight().params())
        }

        val text = textView(ctx) {
            colorRes(R.color.white)
            textSize(20f)
            layoutParams(frameLayoutParams().bottomStart()
                    .marginStart(dp(16))
                    .marginBottom(dp(16))
                    .params())
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