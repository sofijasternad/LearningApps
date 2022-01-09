package ru.freeit.dictapp.data.repo

import ru.freeit.dictapp.data.entity.DictResultData

interface DictRepository {
    fun infoAboutWordBy(word: String, onSuccess: (dictResultData: DictResultData) -> Unit)
}