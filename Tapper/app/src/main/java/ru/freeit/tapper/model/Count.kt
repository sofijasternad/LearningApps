package ru.freeit.tapper.model

import ru.freeit.tapper.core.IntPrefs

class Count(private val intPrefs: IntPrefs, private val countObserver: (count: Int) -> Unit) {
    private var count: Int = 0

    companion object {
        private const val countKey = "count_key"
    }

    init {
        count = intPrefs.int(countKey, 0)
        notifyObservers()
    }

    fun increment() {
        count++
        notifyObservers()
        intPrefs.saveInt(countKey, count)
    }

    private fun notifyObservers() {
        countObserver.invoke(count)
    }

}