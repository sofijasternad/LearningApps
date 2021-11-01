package ru.freeit.myposts.data.repo

import ru.freeit.myposts.R
import ru.freeit.myposts.data.model.Post
import ru.freeit.myposts.ui.screens.posts.PostsUi

abstract class PostsResult {

    abstract fun ui() : PostsUi

    class Success(private val posts: List<Post>) : PostsResult() {
        override fun ui(): PostsUi {
            return PostsUi.Success(posts)
        }
    }
    object MissingInternet : PostsResult() {
        override fun ui(): PostsUi {
            return PostsUi.Error(R.string.missing_internet)
        }
    }
}