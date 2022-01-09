package ru.freeit.dictapp.core.network

import android.os.Handler
import java.net.UnknownHostException
import java.util.concurrent.ExecutorService

open class GetRequest(
    private val url: String,
    private val executor: ExecutorService,
    private val handler: Handler
) {

    fun execute(onSuccess: (json: String) -> Unit, onError: (error: GetError) -> Unit) {
        executor.execute {
            try {
                val json = HttpsConnection(url).get()

                handler.post { onSuccess(json) }

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