package ru.freeit.dictapp

import org.json.JSONArray
import ru.freeit.dictapp.core.firstObject

class DictRepositoryImpl : DictRepository {
    override fun infoAboutWordBy(word: String, onSuccess: (dict: DictResultData) -> Unit) {
        val request = GetRequest("https://api.dictionaryapi.dev/api/v2/entries/ru/$word")
        request.execute(
            { json -> onSuccess(DictResultData.fromJson(json)) },
            { onSuccess(DictResultData.Error(R.string.missing_internet)) }
        )
    }
}