package ru.freeit.ponylist.presentation

import android.content.res.Configuration
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (parent.getChildLayoutPosition(view) != 0 && parent.getChildLayoutPosition(view) != 1) {
                outRect.top = spacing
            }
            if (parent.getChildLayoutPosition(view) % 2 == 0) {
                outRect.right = spacing / 2
            } else {
                outRect.left = spacing / 2
            }
        } else {
            if (parent.getChildLayoutPosition(view) != 0) {
                outRect.top = spacing
            }
        }
    }
}