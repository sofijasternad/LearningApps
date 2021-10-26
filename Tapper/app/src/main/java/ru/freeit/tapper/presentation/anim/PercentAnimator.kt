package ru.freeit.tapper.presentation.anim

import android.animation.Animator
import android.animation.ValueAnimator
import androidx.core.animation.doOnEnd

class PercentAnimator {
    fun animToHigh(duration: Long, onUpdate: (value: ValueAnimator) -> Unit, onEnd: (animator: Animator) -> Unit) {
        ValueAnimator.ofInt(0, 100).apply {
            this.duration = duration
            addUpdateListener(onUpdate)
            doOnEnd(onEnd)
            start()
        }
    }
    fun animToLow(duration: Long, onUpdate: (value: ValueAnimator) -> Unit, onEnd: (animator: Animator) -> Unit) {
        ValueAnimator.ofInt(100, 0).apply {
            this.duration = duration
            addUpdateListener(onUpdate)
            doOnEnd(onEnd)
            start()
        }
    }
}