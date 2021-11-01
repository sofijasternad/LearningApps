package ru.freeit.myposts.data.model

import org.json.JSONObject

data class Post(
    private val id: String,
    private val createdAt: String,
    private val title: String,
    private val content: String,
    private val imageUrl: String
) {

    private val timestampDelimiter = "T"
    private val dateDelimiter = "-"

    fun date() : String {
        val (date, _) = createdAt.split(timestampDelimiter)
        val dateSlices = date.split(dateDelimiter)
        return "${dateSlices.last()}.${dateSlices[1]}.${dateSlices.first()}"
    }

    fun title() = title
    fun image() = imageUrl
    fun text() = content

    companion object {
        fun fromJson(json: JSONObject) : Post {
            return Post(
                json.getString("id"),
                json.getString("createdAt"),
                json.getString("title"),
                json.getString("content"),
                json.getString("image")
            )
        }
    }

}