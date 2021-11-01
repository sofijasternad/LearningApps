package ru.freeit.myposts.data.repo

import ru.freeit.myposts.R
import ru.freeit.myposts.data.webservices.MockApiPostsService

class PostsRepository(private val service: MockApiPostsService) {

    suspend fun posts() : PostsResult {
        return try {
            val posts = service.fetchPosts()
            PostsResult.Success(posts)
        } catch (error: Exception) {
            PostsResult.MissingInternet
        }
    }

}