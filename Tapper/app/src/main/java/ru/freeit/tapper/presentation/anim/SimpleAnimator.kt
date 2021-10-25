package ru.freeit.tapper.presentation.anim

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import androidx.core.animation.doOnEnd

class SimpleAnimator(private val view: View) {
    fun scaleBoth(duration: Long, onEnd: (animator: Animator) -> Unit, vararg values: Float) {
        val scaleX = ObjectAnimator.ofFloat(view, View.SCALE_X, *values)
        val scaleY = ObjectAnimator.ofFloat(view, View.SCALE_Y, *values)
        AnimatorSet().apply {
            this.duration = duration
            playTogether(scaleX, scaleY)
            doOnEnd(onEnd)
            start()
        }
    }
}