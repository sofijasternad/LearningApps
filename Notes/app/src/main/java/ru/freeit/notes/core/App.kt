package ru.freeit.notes.core

import android.app.Application
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.data.repository.NoteRepositoryImpl
import ru.freeit.notes.data.repository.TagRepositoryImpl

class App : Application() {

    private val database by lazy { AppDatabase.database(this) }

    private val noteRepo by lazy { NoteRepositoryImpl(database) }
    private val tagRepo by lazy { TagRepositoryImpl(database) }

    val viewModelFactories by lazy { ViewModelFactories(noteRepo, tagRepo) }

}