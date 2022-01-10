package ru.freeit.dictapp.core.network

import android.os.Handler
import java.net.URL
import java.net.UnknownHostException
import java.util.concurrent.ExecutorService
import javax.net.ssl.HttpsURLConnection

open class GetRequest(
    private val url: String,
    private val executor: ExecutorService,
    private val handler: Handler
) {

    fun execute(onSuccess: (json: String) -> Unit, onError: (error: GetError) -> Unit) {
        executor.execute {

            var conn : HttpsURLConnection? = null

            try {
                val connection = URL(url).openConnection() as HttpsURLConnection
                conn = connection

                connection.requestMethod = "GET"
                connection.setRequestProperty("Content-Type", "application/json; utf-8")
                connection.connectTimeout = 5000
                connection.readTimeout = 5000

                val json = connection.inputStream.bufferedReader().readText()

                handler.post { onSuccess(json) }

            } catch (error: Exception) {
                conn?.disconnect()
                handler.post {
                    if (error is UnknownHostException) {
                        onError(GetError.MISSING_INTERNET)
                    } else {
                        onError(GetError.OTHER)
                    }
                }
            }
        }
    }

}