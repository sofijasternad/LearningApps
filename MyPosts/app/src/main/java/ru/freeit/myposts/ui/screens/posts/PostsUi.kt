package ru.freeit.myposts.ui.screens.posts

import ru.freeit.myposts.data.model.Post

sealed class PostsUi {
    class Success(posts: List<Post>) : PostsUi()
    class Error(stringId: Int) : PostsUi()
}