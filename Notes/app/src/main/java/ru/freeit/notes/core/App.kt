package ru.freeit.notes.core

import android.app.Application
import ru.freeit.notes.data.db.AppDatabase

class App : Application() {

    val database by lazy { AppDatabase.database(this) }

}