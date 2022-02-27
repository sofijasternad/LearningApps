package ru.freeit.tapper.model

import ru.freeit.tapper.core.IntStorage

// our model
class Count(private val intStorage: IntStorage, private val countObserver: (count: Int) -> Unit) {

    // we have some value
    private var count: Int = 0

    init {
        // get saved value from IntStorage
        count = intStorage.int(countKey, 0)
        // say about changes
        countObserver.invoke(count)
    }

    fun increment() {
        // add 1
        count++
        // say about changes
        countObserver.invoke(count)
        // save value in IntStorage
        intStorage.saveInt(countKey, count)
    }

    companion object {
        private const val countKey = "count_key"
    }

}