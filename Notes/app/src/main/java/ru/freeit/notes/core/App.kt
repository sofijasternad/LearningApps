package ru.freeit.notes.core

import android.app.Application
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.data.repository.NoteRepositoryBase
import ru.freeit.notes.data.repository.TagRepositoryBase

class App : Application() {

    private val database by lazy { AppDatabase.database(this) }

    private val noteRepo by lazy { NoteRepositoryBase(database) }
    private val tagRepo by lazy { TagRepositoryBase(database) }

    val viewModelFactories by lazy { ViewModelFactories(noteRepo, tagRepo) }

}