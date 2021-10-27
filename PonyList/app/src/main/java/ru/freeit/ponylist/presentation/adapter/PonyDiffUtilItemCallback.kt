package ru.freeit.ponylist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.freeit.ponylist.model.Pony

class PonyDiffUtilItemCallback : DiffUtil.ItemCallback<Pony>() {

    override fun areItemsTheSame(oldItem: Pony, newItem: Pony): Boolean {
        return oldItem.id() == newItem.id()
    }

    override fun areContentsTheSame(oldItem: Pony, newItem: Pony): Boolean {
        return oldItem == newItem
    }

}