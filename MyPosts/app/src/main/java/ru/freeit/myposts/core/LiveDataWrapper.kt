package ru.freeit.myposts.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class LiveDataWrapper<T> {
    private val liveData = MutableLiveData<T>()

    fun changeValue(data: T) {
        liveData.value = data
    }

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
        liveData.observe(lifecycleOwner, observer)
    }
}