package ru.freeit.ponylist.model

import android.widget.ImageView
import android.widget.TextView

data class Pony(
    private val id: Int = 0,
    private val title: Int,
    private val img: Int,
    private val family: Int
) {
    fun id() = id

    fun name(view: TextView) {
        view.setText(title)
    }
    fun family(view: TextView) {
        view.setText(family)
    }
    fun img(view: ImageView) {
        view.setImageResource(img)
    }
}