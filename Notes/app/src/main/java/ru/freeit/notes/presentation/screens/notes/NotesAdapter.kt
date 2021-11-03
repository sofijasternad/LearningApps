package ru.freeit.notes.presentation.screens.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.freeit.notes.databinding.NoteListItemBinding
import ru.freeit.notes.domain.entity.Note



class NotesAdapter : ListAdapter<Note, NotesAdapter.NotesViewHolder>(NoteDiffUtilCallback()) {

    class NoteDiffUtilCallback() : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id() == newItem.id()
        override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
    }

    class NotesViewHolder(private val binding: NoteListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) {
            binding.titleText.text = note.title()
            binding.editedDateText.text = note.lastEdited()
        }

        companion object {
            fun from(parent: ViewGroup) = NotesViewHolder(NoteListItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NotesViewHolder.from(parent)
    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) = holder.bind(getItem(position))

}