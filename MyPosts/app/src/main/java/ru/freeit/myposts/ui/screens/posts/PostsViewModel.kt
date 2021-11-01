package ru.freeit.myposts.ui.screens.posts

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.freeit.myposts.core.CoroutineViewModel
import ru.freeit.myposts.core.LiveDataWrapper
import ru.freeit.myposts.data.repo.PostsRepository

class PostsViewModel(private val repo: PostsRepository) : CoroutineViewModel() {

    private val posts = LiveDataWrapper<PostsUi>()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                posts.changeValue(repo.posts().ui())
            }
        }
    }


}