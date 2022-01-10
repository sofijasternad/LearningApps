package ru.freeit.dictapp.data.network

import android.os.Handler
import ru.freeit.dictapp.core.network.GetRequest
import java.util.concurrent.ExecutorService

class DictGetRequest(word: String, executor: ExecutorService, handler: Handler)
    : GetRequest("https://api.dictionaryapi.dev/api/v2/entries/ru/$word", executor, handler)