package ru.freeit.dictapp.data

import ru.freeit.dictapp.core.network.GetRequest

class DictGetRequest(word: String) : GetRequest("https://api.dictionaryapi.dev/api/v2/entries/ru/$word")