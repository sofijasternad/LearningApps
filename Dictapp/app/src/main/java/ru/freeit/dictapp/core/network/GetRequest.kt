package ru.freeit.dictapp.core.network

import android.os.Handler
import android.os.Looper
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.UnknownHostException
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

open class GetRequest(private val url: String) {

    private val executor = Executors.newSingleThreadExecutor()
    private val handler = Handler(Looper.getMainLooper())

    fun execute(onSuccess: (json: String) -> Unit, onError: (error: GetError) -> Unit) {
        executor.execute {
            try {
                val connection = URL(url).openConnection() as HttpsURLConnection
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