package ru.freeit.myposts.ui.screens.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.freeit.myposts.data.repo.PostsRepository

class PostsViewModelFactory(private val repo: PostsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(repo) as T
    }
}