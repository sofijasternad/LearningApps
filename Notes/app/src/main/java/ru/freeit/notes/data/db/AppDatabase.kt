package ru.freeit.notes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.freeit.notes.data.db.dao.NoteDao
import ru.freeit.notes.data.db.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object {
        private const val databaseName = "app_database"

        fun database(appContext: Context) : AppDatabase = Room.databaseBuilder(
            appContext, AppDatabase::class.java, databaseName
        ).build()
    }
}