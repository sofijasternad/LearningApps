package ru.freeit.dictapp.core.network

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class StringBufferedInputStream(private val input: InputStream) {
    fun read() : String {
        val reader = BufferedReader(InputStreamReader(input))
        val content = StringBuffer()
        var inputLine = reader.readLine()
        while (inputLine != null) {
            content.append(inputLine)
            inputLine = reader.readLine()
        }
        return content.toString()
    }
}