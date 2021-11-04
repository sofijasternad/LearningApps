package ru.freeit.notes.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class LiveDataWrapper<T> {
    private val liveData = MutableLiveData<T>()
    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>) = liveData.observe(lifecycleOwner, observer)
    fun changeValue(value: T) {
        liveData.value = value
    }
    fun value() = liveData.value
}