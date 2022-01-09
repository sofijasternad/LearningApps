package ru.freeit.dictapp.data.repo

import android.os.Handler
import ru.freeit.dictapp.data.network.DictGetRequest
import ru.freeit.dictapp.data.entity.DictResultData
import java.util.concurrent.ExecutorService

class DictRepositoryImpl(private val executor: ExecutorService, private val handler: Handler) :
    DictRepository {
    override fun infoAboutWordBy(word: String, onSuccess: (dict: DictResultData) -> Unit) {
        val request = DictGetRequest(word, executor, handler)
        request.execute(
            { json -> onSuccess(DictResultData.fromJson(json)) },
            { error -> onSuccess(DictResultData.Error(error.resId)) }
        )
    }
}