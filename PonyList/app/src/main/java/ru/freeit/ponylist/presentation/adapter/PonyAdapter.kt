package ru.freeit.ponylist.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.freeit.ponylist.model.Pony

class PonyAdapter : ListAdapter<Pony, PonyViewHolder>(PonyDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PonyViewHolder {
        return PonyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PonyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}