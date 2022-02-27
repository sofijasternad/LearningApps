package ru.freeit.ponylist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.ponylist.model.Pony
import ru.freeit.ponylist.databinding.PonyListItemBinding

class PonyViewHolder(private val binding: PonyListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pony: Pony) {
        with(binding) {
            pony.name(name)
            pony.family(family)
            pony.img(img)
        }
    }

    companion object {
        fun from(parent: ViewGroup) : PonyViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val item = PonyListItemBinding.inflate(inflater, parent, false)
            return PonyViewHolder(item)
        }
    }

}