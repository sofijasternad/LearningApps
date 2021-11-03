package ru.freeit.notes.core

import android.app.Application
import ru.freeit.notes.data.db.AppDatabase
import ru.freeit.notes.data.repository.NoteRepositoryImpl

class App : Application() {

    private val database by lazy { AppDatabase.database(this) }

    val repo by lazy { NoteRepositoryImpl(database) }

}