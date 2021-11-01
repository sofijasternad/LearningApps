package ru.freeit.myposts.ui.screens.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.freeit.myposts.data.repo.PostsRepository
import ru.freeit.myposts.data.webservices.MockApiPostsService
import ru.freeit.myposts.databinding.PostsFragmentBinding

class PostsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = PostsFragmentBinding.inflate(inflater, container, false)

        val repo = PostsRepository(MockApiPostsService())
        val factory = PostsViewModelFactory(repo)
        val viewModel = ViewModelProvider(this, factory).get(PostsViewModel::class.java)

        viewModel.state(this) { postUi ->
            when(postUi) {
                is PostsUi.Success -> {
                    binding.progressCircular.isVisible = false
                    binding.errorText.isVisible = false

                    binding.postList.adapter = PostsAdapter(postUi.posts())
                }
                is PostsUi.Error -> {
                    binding.progressCircular.isVisible = false
                    binding.errorText.isVisible = true

                    binding.errorText.setText(postUi.strId())
                }
                is PostsUi.Loading -> {
                    binding.errorText.isVisible = false
                    binding.progressCircular.isVisible = true
                }
            }
        }

        return binding.root
    }

}