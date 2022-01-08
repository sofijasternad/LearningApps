package ru.freeit.dictapp.data

import ru.freeit.dictapp.data.DictResultData

interface DictRepository {
    fun infoAboutWordBy(word: String, onSuccess: (dictResultData: DictResultData) -> Unit)
}