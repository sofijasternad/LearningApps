package ru.freeit.myposts.ui.screens.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.freeit.myposts.data.model.Post
import ru.freeit.myposts.databinding.PostListItemBinding

class PostsAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    class PostViewHolder(private val binding:  PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post) {
            binding.postTitle.text = post.title()
            binding.postCreatedDate.text = post.date()
            binding.postContent.text = post.text()

            Glide.with(binding.postTitle).load(post.image()).into(binding.postImg)
        }

        companion object {
            fun from(parent: ViewGroup) = PostViewHolder(PostListItemBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }

    override fun getItemCount() = posts.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder.from(parent)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) = holder.bind(posts[position])

}