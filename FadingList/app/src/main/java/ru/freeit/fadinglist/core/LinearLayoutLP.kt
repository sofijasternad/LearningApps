package ru.freeit.fadinglist.core

import androidx.appcompat.widget.LinearLayoutCompat

fun linearLayoutParams() = LinearLayoutLP()

class LinearLayoutLP(private var params: LinearLayoutCompat.LayoutParams = LinearLayoutCompat.LayoutParams(
    LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT)
) {

    fun width(dp: Int) = LinearLayoutLP(params.apply {
        width = dp
    })

    fun height(dp: Int) = LinearLayoutLP(params.apply {
        height = dp
    })

    fun matchWidth() = LinearLayoutLP(params.apply {
        width = LinearLayoutCompat.LayoutParams.MATCH_PARENT
    })

    fun wrapWidth() = LinearLayoutLP(params.apply {
        width = LinearLayoutCompat.LayoutParams.WRAP_CONTENT
    })

    fun matchHeight() = LinearLayoutLP(params.apply {
        height = LinearLayoutCompat.LayoutParams.MATCH_PARENT
    })

    fun wrapHeight() = LinearLayoutLP(params.apply {
        height = LinearLayoutCompat.LayoutParams.WRAP_CONTENT
    })

    fun weight(w: Float) = LinearLayoutLP(params.apply {
        weight = w
    })

    fun marginStart(dp: Int) = LinearLayoutLP(params.apply {
        marginStart = dp
    })

    fun marginTop(dp: Int) = LinearLayoutLP(params.apply {
        topMargin = dp
    })

    fun marginBottom(dp: Int) = LinearLayoutLP(params.apply {
        bottomMargin = dp
    })

    fun marginEnd(dp: Int) = LinearLayoutLP(params.apply {
        marginEnd = dp
    })

    fun margins(startDp: Int, topDp: Int, endDp: Int, bottomDp: Int) = LinearLayoutLP(params.apply {
        marginStart = startDp
        marginEnd = endDp
        topMargin = topDp
        bottomMargin = bottomDp
    })

    fun params() = params

}