package ru.freeit.dictapp

interface DictRepository {
    fun infoAboutWordBy(word: String, onSuccess: (dictResultData: DictResultData) -> Unit)
}