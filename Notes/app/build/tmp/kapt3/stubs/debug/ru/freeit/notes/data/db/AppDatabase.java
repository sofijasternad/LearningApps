package ru.freeit.notes.data.db;

import java.lang.System;

@androidx.room.Database(version = 1, entities = {ru.freeit.notes.data.db.entity.Note.class, ru.freeit.notes.data.db.entity.Tag.class}, exportSchema = true)
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lru/freeit/notes/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "noteDao", "Lru/freeit/notes/data/db/dao/NoteDao;", "tagDao", "Lru/freeit/notes/data/db/dao/TagDao;", "Companion", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final ru.freeit.notes.data.db.AppDatabase.Companion Companion = null;
    private static final java.lang.String databaseName = "app_database";
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.freeit.notes.data.db.dao.NoteDao noteDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ru.freeit.notes.data.db.dao.TagDao tagDao();
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lru/freeit/notes/data/db/AppDatabase$Companion;", "", "()V", "databaseName", "", "database", "Lru/freeit/notes/data/db/AppDatabase;", "appContext", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final ru.freeit.notes.data.db.AppDatabase database(@org.jetbrains.annotations.NotNull()
        android.content.Context appContext) {
            return null;
        }
    }
}