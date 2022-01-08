package ru.freeit.dictapp

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class DictViewModel(private val repo: DictRepository) : ViewModel() {

    private val wordUi = MutableLiveData<DictResultUi>()

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<DictResultUi>) = wordUi.observe(lifecycleOwner, observer)

    fun found(word: String) {
        wordUi.value = DictResultUi.Loading
        repo.infoAboutWordBy(word) { result -> wordUi.value = result.toUi() }
    }

}