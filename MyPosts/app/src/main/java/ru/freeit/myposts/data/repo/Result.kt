package ru.freeit.myposts.data.repo

import ru.freeit.myposts.data.model.Post

sealed class PostsResult {
    class Success(posts: List<Post>) : PostsResult()
    class Error(stringId: Int) : PostsResult()
    object Loading : PostsResult()
}