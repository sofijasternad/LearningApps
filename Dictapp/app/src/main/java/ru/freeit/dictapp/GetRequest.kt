package ru.freeit.dictapp

import android.os.Handler
import android.os.Looper
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException
import java.util.concurrent.Executors

class GetRequest(private val url: String, private val params: Map<String, String> = mapOf()) {

    private val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
    private val handler = Handler(Looper.getMainLooper())

    fun withParam(key: String, value: String) = GetRequest(url, params.toMutableMap().apply { put(key, value) })

    fun execute(onSuccess: (json: String) -> Unit, onError: () -> Unit) {
        executor.execute {
            try {
                val paramStr = params.map { entry -> "${entry.key}=${entry.value}" }.joinToString("&")
                val connection = URL("$url?$paramStr").openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.setRequestProperty("Content-Type", "application/json")
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

            } catch (missingInternet: UnknownHostException) {
                handler.post { onError() }
            }
        }
    }

}