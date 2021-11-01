package ru.freeit.myposts.ui.screens.posts

import ru.freeit.myposts.data.model.Post

sealed class PostsUi {
    class Success(private val posts: List<Post>) : PostsUi() {
        fun posts() = posts
    }
    class Error(private val stringId: Int) : PostsUi() {
        fun strId() = stringId
    }
    object Loading : PostsUi()
}