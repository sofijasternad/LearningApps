package ru.freeit.dictapp.core.network

import java.net.URL
import javax.net.ssl.HttpsURLConnection

class HttpsConnection(private val url: String) {
    fun get(timeout: Int = 5000) : String {
        val connection = URL(url).openConnection() as HttpsURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json; utf-8")
        connection.connectTimeout = timeout
        connection.readTimeout = timeout

        val content = StringBufferedInputStream(connection.inputStream).read()

        connection.disconnect()

        return content
    }
}