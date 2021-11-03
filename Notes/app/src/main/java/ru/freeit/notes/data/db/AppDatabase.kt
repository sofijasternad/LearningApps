package ru.freeit.notes.data.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.freeit.notes.data.db.dao.NoteDao
import ru.freeit.notes.data.db.entity.Note
import ru.freeit.notes.data.db.entity.Tag

@Database(version = 1, entities = [Note::class, Tag::class], exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object {
        private const val databaseName = "app_database"

        fun database(appContext: Context) : AppDatabase = Room.databaseBuilder(
            appContext, AppDatabase::class.java, databaseName
        ).build()
    }
}