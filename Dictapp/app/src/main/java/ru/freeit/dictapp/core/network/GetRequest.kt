package ru.freeit.dictapp.core.network

import android.os.Handler
import android.os.Looper
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.UnknownHostException
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

open class GetRequest(private val url: String, private val params: Map<String, String> = mapOf()) {

    private val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    private val handler = Handler(Looper.getMainLooper())

    fun withParam(key: String, value: String) = GetRequest(url, params.toMutableMap().apply { put(key, value) })

    fun execute(onSuccess: (json: String) -> Unit, onError: (error: GetError) -> Unit) {
        executor.execute {
            try {

                val str = if (params.isEmpty()) {
                    url
                } else {
                    val paramStr = params.map { entry -> "${entry.key}=${entry.value}" }.joinToString("&")
                    "$url?$paramStr"
                }

                val connection = URL(str).openConnection() as HttpsURLConnection
                connection.requestMethod = "GET"
                connection.setRequestProperty("Content-Type", "application/json; utf-8")
                connection.connectTimeout = 5000
                connection.readTimeout = 5000

                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val content = StringBuffer()
                var inputLine = reader.readLine()
                while (inputLine != null) {
                    content.append(inputLine)
                    inputLine = reader.readLine()
                }

                connection.disconnect()

                handler.post { onSuccess(content.toString()) }

            } catch (error: Exception) {
                error.printStackTrace()
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