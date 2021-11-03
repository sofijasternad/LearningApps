package ru.freeit.notes.presentation.screens.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.databinding.NotesScreenBinding
import ru.freeit.notes.domain.entity.Note

class NotesViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NotesViewModel(database) as T
    }
}

class LiveDataWrapper<T> {
    private val liveData = MutableLiveData<T>()
    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>) = liveData.observe(lifecycleOwner, observer)
    fun changeValue(value: T) {
        liveData.value = value
    }
}

class NotesViewModel(private val database: AppDatabase) {

    private val notes = LiveDataWrapper<List<Note>>()

    fun init() {

    }
}

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