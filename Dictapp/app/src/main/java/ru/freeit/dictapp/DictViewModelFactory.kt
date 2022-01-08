package ru.freeit.dictapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DictViewModelFactory(private val repo: DictRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>) = DictViewModel(repo) as T
}