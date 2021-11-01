package ru.freeit.myposts.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.freeit.myposts.databinding.PostsFragmentBinding

class PostsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = PostsFragmentBinding.inflate(inflater, container, false)



        return binding.root
    }

}