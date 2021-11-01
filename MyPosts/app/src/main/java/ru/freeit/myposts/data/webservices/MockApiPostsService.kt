package ru.freeit.myposts.data.webservices

import org.json.JSONArray
import org.json.JSONObject
import ru.freeit.myposts.data.model.Post
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MockApiPostsService {

    private fun JSONArray.mapJsonObjects() : List<JSONObject> {
        val jsonObjects = mutableListOf<JSONObject>()
        for (i in 0 until length()) {
            jsonObjects.add(getJSONObject(i))
        }
        return jsonObjects
    }

    private val mockApiPostsUrl = "https://617f607b055276001774fa5f.mockapi.io/api/v3/posts"

    suspend fun fetchPosts() : List<Post> {
        val connection = URL(mockApiPostsUrl).openConnection() as HttpsURLConnection
        connection.requestMethod = "GET"
        connection.setRequestProperty("Accept", "application/json")
        BufferedReader(InputStreamReader(connection.inputStream, "utf-8")).use {  reader ->
            val jsonContent = StringBuilder()
            var line: String? = reader.readLine()
            while (line != null) {
                jsonContent.append(line.trim())
                line = reader.readLine()
            }
            connection.disconnect()
            val postsJson = JSONArray(jsonContent.toString())
            return postsJson.mapJsonObjects().map { postJson ->
                Post.fromJson(postJson)
            }
        }
    }

}