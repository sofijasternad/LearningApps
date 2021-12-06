package ru.freeit.fadinglist.core

import android.view.Gravity
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

fun frameLayoutParams() = FrameLayoutLP()
fun recyclerViewParams() = RecyclerViewLP()

class RecyclerViewLP(private val params: RecyclerView.LayoutParams = RecyclerView.LayoutParams(
    RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT)
) {

    fun marginBottom(dp: Int) = RecyclerViewLP(params.apply {
        bottomMargin = dp
    })

    fun params() = params

}

class FrameLayoutLP(private val params: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
    FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
) {
    fun matchWidth() = FrameLayoutLP(params.apply {
        width = FrameLayout.LayoutParams.MATCH_PARENT
    })

    fun width(dp: Int) = FrameLayoutLP(params.apply {
        width = FrameLayout.LayoutParams.WRAP_CONTENT
    })

    fun center() = FrameLayoutLP(params.apply {
        gravity = Gravity.CENTER
    })

    fun bottomStart() = FrameLayoutLP(params.apply {
        gravity = Gravity.BOTTOM or Gravity.START
    })

    fun marginStart(dp: Int) = FrameLayoutLP(params.apply {
        marginStart = dp
    })

    fun marginBottom(dp: Int) = FrameLayoutLP(params.apply {
        bottomMargin = dp
    })


    fun wrapWidth() = FrameLayoutLP(params.apply {
        width = FrameLayout.LayoutParams.WRAP_CONTENT
    })

    fun height(dp: Int) = FrameLayoutLP(params.apply {
        height = dp
    })

    fun matchHeight() = FrameLayoutLP(params.apply {
        height = FrameLayout.LayoutParams.MATCH_PARENT
    })

    fun wrapHeight() = FrameLayoutLP(params.apply {
        height = FrameLayout.LayoutParams.WRAP_CONTENT
    })

    fun gravity(grav: Int) = FrameLayoutLP(params.apply {
        gravity = grav
    })

    fun params() = params

    fun margins(startDp: Int, topDp: Int, endDp: Int, bottomDp: Int) = FrameLayoutLP(params.apply {
        marginStart = startDp
        marginEnd = endDp
        topMargin = topDp
        bottomMargin = bottomDp
    })
}