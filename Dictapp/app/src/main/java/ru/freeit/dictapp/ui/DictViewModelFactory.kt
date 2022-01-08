package ru.freeit.dictapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.freeit.dictapp.data.DictRepository

class DictViewModelFactory(private val repo: DictRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>) = DictViewModel(repo) as T
}