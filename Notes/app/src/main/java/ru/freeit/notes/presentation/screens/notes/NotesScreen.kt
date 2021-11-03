package ru.freeit.notes.presentation.screens.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.freeit.notes.databinding.NotesScreenBinding

class NotesScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NotesScreenBinding.inflate(inflater)

        return binding.root
    }
}