package ru.freeit.dictapp.data

class DictRepositoryImpl : DictRepository {
    override fun infoAboutWordBy(word: String, onSuccess: (dict: DictResultData) -> Unit) {
        val request = DictGetRequest(word)
        request.execute(
            { json -> onSuccess(DictResultData.fromJson(json)) },
            { error -> onSuccess(DictResultData.Error(error.resId)) }
        )
    }
}