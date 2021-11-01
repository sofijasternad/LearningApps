package ru.freeit.myposts.ui.screens.posts

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.freeit.myposts.core.CoroutineViewModel
import ru.freeit.myposts.core.LiveDataWrapper
import ru.freeit.myposts.data.repo.PostsRepository

class PostsViewModel(private val repo: PostsRepository) : CoroutineViewModel() {

    private val posts = LiveDataWrapper<PostsUi>()

    fun state(lifecycleOwner: LifecycleOwner, observer: Observer<PostsUi>) = posts.observe(lifecycleOwner, observer)

    init {
        viewModelScope.launch {
            posts.changeValue(PostsUi.Loading)
            val postsUi = withContext(Dispatchers.IO) {
                repo.posts().ui()
            }
            posts.changeValue(postsUi)
        }
    }


}