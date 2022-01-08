package ru.freeit.dictapp.core

import android.os.Handler

class Debounce(private val handler: Handler) {

    fun run(runnable: Runnable, delay: Long = 500) {
        handler.removeCallbacks(runnable)
        handler.postDelayed(runnable, delay)
    }

}