package ru.freeit.fadinglist.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes private val titleResId: Int,
    @DrawableRes private val imageResId: Int
) {
    fun title(text: TextView) {
        text.setText(titleResId)
    }
    fun img(image: ImageView) {
        image.setImageResource(imageResId)
    }
}