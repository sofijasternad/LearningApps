package ru.freeit.notes.presentation.screens.note

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import com.google.android.material.chip.Chip
import ru.freeit.notes.R

class AddChip @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : Chip(ctx, attrs, defStyleAttr) {

    init {
        setChipBackgroundColorResource(R.color.orange_500)
        setChipIconResource(R.drawable.ic_add_24)
        setTextColor(Color.WHITE)
        chipIconTint = ColorStateList.valueOf(Color.WHITE)
    }
}